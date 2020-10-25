package br.com.insight.ufc.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "curriculum-ws")
public interface CurriculumClient {


}
