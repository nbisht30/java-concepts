package com.FileIO.ByteStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* COPYING USNG JUST FileInputStream AND FileOutputStream IS SLOW*/
public class CopyingATextFileFileIOStream {
	public static void main(String[] args) throws FileNotFoundException {
		
		//using try with resources
		try (FileOutputStream fileOp = new FileOutputStream("C:\\tmp\\file.txt");
				FileInputStream fileIp = new FileInputStream("C:\\tmp \\fileToCopy.txt")) {
			int byteRead;
			double startTime = System.nanoTime();
			while ((byteRead = fileIp.read()) != -1) {
				fileOp.write(byteRead);
			}
			double endTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time = " + endTime / 1000000 + "msec");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
