package com.ailyr.tool.log;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ailyr.tool.core.io.resource.ResourceUtil;
import com.ailyr.tool.core.lang.Caller;
import com.ailyr.tool.log.dialect.commons.ApacheCommonsLogFactory;
import com.ailyr.tool.log.dialect.console.ConsoleLogFactory;
import com.ailyr.tool.log.dialect.jdk.JdkLogFactory;
import com.ailyr.tool.log.dialect.log4j.Log4jLogFactory;
import com.ailyr.tool.log.dialect.log4j2.Log4j2LogFactory;
import com.ailyr.tool.log.dialect.slf4j.Slf4jLogFactory;
import com.ailyr.tool.log.dialect.tinylog.TinyLogFactory;

/**
 * 日志工厂类
 * 
 * @see Slf4jLogFactory
 * @see Log4j2LogFactory
 * @see Log4jLogFactory
 * @see ApacheCommonsLogFactory
 * @see TinyLogFactory
 * @see ConsoleLogFactory
 * @see JdkLogFactory
 * 
 * @author Looly
 *
 */
public abstract class LogFactory {

	protected String logFramworkName;
	private Map<Object, Log> logCache;

	public LogFactory(String logFramworkName) {
		this.logFramworkName = logFramworkName;
		logCache = new ConcurrentHashMap<>();
	}

	/**
	 * 获得日志对象
	 * 
	 * @param name 日志对象名
	 * @return 日志对象
	 */
	public Log getLog(String name) {
		Log log = logCache.get(name);
		if (null == log) {
			log = createLog(name);
			logCache.put(name, log);
		}
		return log;
	}

	/**
	 * 获得日志对象
	 * 
	 * @param clazz 日志对应类
	 * @return 日志对象
	 */
	public Log getLog(Class<?> clazz) {
		Log log = logCache.get(clazz);
		if (null == log) {
			log = createLog(clazz);
			logCache.put(clazz, log);
		}
		return log;
	}

	/**
	 * 创建日志对象
	 * 
	 * @param name 日志对象名
	 * @return 日志对象
	 */
	public abstract Log createLog(String name);

	/**
	 * 创建日志对象
	 * 
	 * @param clazz 日志对应类
	 * @return 日志对象
	 */
	public abstract Log createLog(Class<?> clazz);

	/**
	 * 检查日志实现是否存在<br>
	 * 此方法仅用于检查所提供的日志相关类是否存在，当传入的日志类类不存在时抛出ClassNotFoundException<br>
	 * 此方法的作用是在detectLogFactory方法自动检测所用日志时，如果实现类不存在，调用此方法会自动抛出异常，从而切换到下一种日志的检测。
	 * 
	 * @param logClassName 日志实现相关类
	 */
	protected void checkLogExist(Object logClassName) {
		// 不做任何操作
	}

	// ------------------------------------------------------------------------- Static start
	/**
	 * @return 当前使用的日志工厂
	 */
	public static LogFactory getCurrentLogFactory() {
		return GlobalLogFactory.get();
	}

	/**
	 * 自定义日志实现
	 * 
	 * @see Slf4jLogFactory
	 * @see Log4jLogFactory
	 * @see Log4j2LogFactory
	 * @see ApacheCommonsLogFactory
	 * @see JdkLogFactory
	 * @see ConsoleLogFactory
	 * 
	 * @param logFactoryClass 日志工厂类
	 * @return 自定义的日志工厂类
	 */
	public static LogFactory setCurrentLogFactory(Class<? extends LogFactory> logFactoryClass) {
		return GlobalLogFactory.set(logFactoryClass);
	}

	/**
	 * 自定义日志实现
	 * 
	 * @see Slf4jLogFactory
	 * @see Log4jLogFactory
	 * @see Log4j2LogFactory
	 * @see ApacheCommonsLogFactory
	 * @see JdkLogFactory
	 * @see ConsoleLogFactory
	 * 
	 * @param logFactory 日志工厂类对象
	 * @return 自定义的日志工厂类
	 */
	public static LogFactory setCurrentLogFactory(LogFactory logFactory) {
		return GlobalLogFactory.set(logFactory);
	}

	/**
	 * 获得日志对象
	 * 
	 * @param name 日志对象名
	 * @return 日志对象
	 */
	public static Log get(String name) {
		return getCurrentLogFactory().getLog(name);
	}

	/**
	 * 获得日志对象
	 * 
	 * @param clazz 日志对应类
	 * @return 日志对象
	 */
	public static Log get(Class<?> clazz) {
		return getCurrentLogFactory().getLog(clazz);
	}

	/**
	 * @return 获得调用者的日志
	 */
	public static Log get() {
		return get(Caller.getCallerCaller());
	}

	/**
	 * 决定日志实现
	 * 
	 * @see Slf4jLogFactory
	 * @see Log4j2LogFactory
	 * @see Log4jLogFactory
	 * @see ApacheCommonsLogFactory
	 * @see ConsoleLogFactory
	 * @see JdkLogFactory
	 * @return 日志实现类
	 */
	public static LogFactory create() {
		LogFactory logFactory;
		try {
			logFactory = new Slf4jLogFactory(true);
		} catch (NoClassDefFoundError e) {
			try {
				logFactory = new Log4j2LogFactory();
			} catch (NoClassDefFoundError e2) {
				try {
					logFactory = new Log4jLogFactory();
				} catch (NoClassDefFoundError e3) {
					try {
						logFactory = new ApacheCommonsLogFactory();
					} catch (NoClassDefFoundError e4) {
						try {
							logFactory = new TinyLogFactory();
						} catch (NoClassDefFoundError e5) {
							// 未找到任何可支持的日志库时判断依据：当JDK Logging的配置文件位于classpath中，使用JDK Logging，否则使用Console
							final URL url = ResourceUtil.getResource("logging.properties");
							logFactory = (null != url) ? new JdkLogFactory() : new ConsoleLogFactory();
						}
					}
				}
			}
		}

		return logFactory;
	}
	// ------------------------------------------------------------------------- Static end
}
