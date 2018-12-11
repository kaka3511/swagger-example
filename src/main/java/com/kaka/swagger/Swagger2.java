/**
 * <p>Description: swagger2配置信息</p>
 * @author 徐安安
 * @date 2018年6月7日 
 * @version 1.0 
 */
package com.kaka.swagger;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
public class Swagger2 {

	@Bean
	public Docket createRestApi() {

		//这段配置是为了在swagger-ui界面显示header，方便token输入
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();

		List<Parameter> aParameters = Lists.newArrayList();
		aParameters.add(aParameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(aParameters)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kaka.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("测试api文档")
				.description("测试api文档")
				.version("1.0")
				.build();
	}
}
