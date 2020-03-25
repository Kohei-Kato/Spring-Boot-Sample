package com.example.sample.sysbase.config;

import com.example.sample.sysbase.filter.SampleFilter;
import com.example.sample.sysbase.filter.SampleFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    /**
     * フィルタ1のオブジェクトをコンポーネントに追加.
     * @return フィルタ1を登録したBean
     */
    @Bean
    public FilterRegistrationBean setSampleFilter1(){
        //フィルタ1のオブジェクトを1番目に実行するフィルタとして追加
        FilterRegistrationBean bean = new FilterRegistrationBean(new SampleFilter());
        //コントローラ・静的コンテンツ全てのリクエストに対してフィルタ1を有効化
        bean.addUrlPatterns("/*");
        //フィルタ1の実行順序を1に設定
        bean.setOrder(1);
        return bean;
    }

    /**
     * フィルタ2のオブジェクトをコンポーネントに追加.
     * @return フィルタ1を登録したBean
     */
    @Bean
    public FilterRegistrationBean setSampleFilter2(){
        //フィルタ1のオブジェクトを1番目に実行するフィルタとして追加
        FilterRegistrationBean bean = new FilterRegistrationBean(new SampleFilter2());
        // URLが/sampleのリクエストに対してフィルタ2を有効化
        bean.addUrlPatterns("/sample");
        //フィルタ1の実行順序を2に設定
        bean.setOrder(2);
        return bean;
    }
}
