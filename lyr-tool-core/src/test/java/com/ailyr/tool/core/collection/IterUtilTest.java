package com.ailyr.tool.core.collection;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.core.collection.CollUtil;
import com.ailyr.tool.core.collection.IterUtil;

/**
 * {@link IterUtil} 单元测试
 * @author looly
 *
 */
public class IterUtilTest {
	
	@Test
	public void countMapTest() {
		ArrayList<String> list = CollUtil.newArrayList("a", "b", "c", "c", "a", "b", "d");
		Map<String, Integer> countMap = IterUtil.countMap(list);
		
		Assert.assertEquals(Integer.valueOf(2), countMap.get("a"));
		Assert.assertEquals(Integer.valueOf(2), countMap.get("b"));
		Assert.assertEquals(Integer.valueOf(2), countMap.get("c"));
		Assert.assertEquals(Integer.valueOf(1), countMap.get("d"));
	}

	@Test
	public void fieldValueMapTest() {
		ArrayList<Car> carList = CollUtil.newArrayList(new Car("123", "大众"), new Car("345", "奔驰"), new Car("567", "路虎"));
		Map<String, Car> carNameMap = IterUtil.fieldValueMap(carList, "carNumber");
		
		Assert.assertEquals("大众", carNameMap.get("123").getCarName());
		Assert.assertEquals("奔驰", carNameMap.get("345").getCarName());
		Assert.assertEquals("路虎", carNameMap.get("567").getCarName());
	}

	public static class Car {
		private String carNumber;
		private String carName;

		public Car(String carNumber, String carName) {
			this.carNumber = carNumber;
			this.carName = carName;
		}

		public String getCarNumber() {
			return carNumber;
		}

		public void setCarNumber(String carNumber) {
			this.carNumber = carNumber;
		}

		public String getCarName() {
			return carName;
		}

		public void setCarName(String carName) {
			this.carName = carName;
		}
	}
}
