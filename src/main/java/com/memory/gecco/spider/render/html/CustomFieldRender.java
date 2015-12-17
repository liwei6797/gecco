package com.memory.gecco.spider.render.html;

import java.lang.reflect.Field;

import net.sf.cglib.beans.BeanMap;

import com.memory.gecco.request.HttpRequest;
import com.memory.gecco.response.HttpResponse;
import com.memory.gecco.spider.SpiderBean;

/**
 * 属性的渲染有时会较复杂，不能用上述注解描述，gecco爬虫支持属性渲染的自定义方式，自定义渲染器实现CustomFieldRender接口，并定义属性渲染器名称。
 * 
 * @author huchengyi
 *
 */
public interface CustomFieldRender {
	
	public void render(HttpRequest request, HttpResponse response, BeanMap beanMap, SpiderBean bean, Field field);

}