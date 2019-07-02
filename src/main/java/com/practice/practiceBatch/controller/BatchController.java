package com.practice.practiceBatch.controller;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.practice.practiceBatch.exception.BatchException;
import com.practice.practiceBatch.model.read.StudentObj;
import com.practice.practiceBatch.reader.BatchDataReader;

@Service
public class BatchController {

	@Scheduled(fixedRate=6000)
	public void batchStart() {
		System.out.println("Batch Started \n\n\n\n");
		try {
			List<StudentObj> students = BatchDataReader.getInstance().getStudents();
//			System.out.println(students.get(0));
		} catch (BatchException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
