package com.ailyr.tool.script;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.ailyr.tool.core.util.StrUtil;

/**
 * 全功能引擎类，支持Compilable和Invocable
 * @author Looly
 *
 */
public class FullSupportScriptEngine implements ScriptEngine, Compilable, Invocable{
	
	ScriptEngine engine;
	
	public FullSupportScriptEngine(ScriptEngine engine) {
		this.engine = engine;
	}
	
	public FullSupportScriptEngine(String nameOrExtOrMime) {
		ScriptEngineManager manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName(nameOrExtOrMime);
		if(null == this.engine){
			manager.getEngineByExtension(nameOrExtOrMime);
		}
		if(null == this.engine){
			manager.getEngineByMimeType(nameOrExtOrMime);
		}
		if(null == this.engine){
			throw new NullPointerException(StrUtil.format("Script for [{}] not support !", nameOrExtOrMime));
		}
	}
	
	//----------------------------------------------------------------------------------------------- Invocable
	@Override
	public Object invokeMethod(Object thiz, String name, Object... args) throws ScriptException, NoSuchMethodException {
		return ((Invocable)engine).invokeMethod(thiz, name, args);
	}

	@Override
	public Object invokeFunction(String name, Object... args) throws ScriptException, NoSuchMethodException {
		return ((Invocable)engine).invokeFunction(name, args);
	}

	@Override
	public <T> T getInterface(Class<T> clasz) {
		return ((Invocable)engine).getInterface(clasz);
	}

	@Override
	public <T> T getInterface(Object thiz, Class<T> clasz) {
		return ((Invocable)engine).getInterface(thiz, clasz);
	}

	//----------------------------------------------------------------------------------------------- Compilable
	@Override
	public CompiledScript compile(String script) throws ScriptException {
		return ((Compilable)engine).compile(script);
	}

	@Override
	public CompiledScript compile(Reader script) throws ScriptException {
		return ((Compilable)engine).compile(script);
	}

	//----------------------------------------------------------------------------------------------- ScriptEngine
	@Override
	public Object eval(String script, ScriptContext context) throws ScriptException {
		return engine.eval(script, context);
	}

	@Override
	public Object eval(Reader reader, ScriptContext context) throws ScriptException {
		return engine.eval(reader, context);
	}

	@Override
	public Object eval(String script) throws ScriptException {
		return engine.eval(script);
	}

	@Override
	public Object eval(Reader reader) throws ScriptException {
		return engine.eval(reader);
	}

	@Override
	public Object eval(String script, Bindings n) throws ScriptException {
		return engine.eval(script, n);
	}

	@Override
	public Object eval(Reader reader, Bindings n) throws ScriptException {
		return engine.eval(reader, n);
	}

	@Override
	public void put(String key, Object value) {
		engine.put(key, value);
	}

	@Override
	public Object get(String key) {
		return engine.get(key);
	}

	@Override
	public Bindings getBindings(int scope) {
		return engine.getBindings(scope);
	}

	@Override
	public void setBindings(Bindings bindings, int scope) {
		engine.setBindings(bindings, scope);
	}

	@Override
	public Bindings createBindings() {
		return engine.createBindings();
	}

	@Override
	public ScriptContext getContext() {
		return engine.getContext();
	}

	@Override
	public void setContext(ScriptContext context) {
		engine.setContext(context);
	}

	@Override
	public ScriptEngineFactory getFactory() {
		return engine.getFactory();
	}

}
