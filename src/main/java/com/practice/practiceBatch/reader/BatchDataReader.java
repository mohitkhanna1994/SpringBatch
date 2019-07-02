package com.practice.practiceBatch.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.practiceBatch.exception.BatchException;
import com.practice.practiceBatch.model.read.StudentObj;

@Service
public class BatchDataReader {

	private static BatchDataReader batchDataReader;

	private BatchDataReader() {

	}

	public List<StudentObj> getStudents() throws BatchException, InterruptedException{
//		return new MySqlReader().findAllStudents();
		return new ArrayList<>();
	}

	public static BatchDataReader getInstance() {
		if (null != batchDataReader)
			return batchDataReader;
		else
			return new BatchDataReader();
	}
}
