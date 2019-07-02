package com.practice.practiceBatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.practice.practiceBatch.controller.BatchController;

@Configuration
@EnableScheduling
public class BatchConfiguration {

	public BatchController batchInitialier() {
		System.out.println("Call batch job::");
		System.out.println("BATCH     ::  \n");
		return new BatchController();
	}
}
