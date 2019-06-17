package com.FileIO.ByteStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* COPYING USNG BufferedInputStream AND BufferedOutputStream IS FAST BECAUSE OF BUFFERING
 * THIS IS MOST COMMON WAY TO READ/WRITE BYTES*/
public class CopyingAFileUsingBufferedIOStreams {
public static void main(String[] args) throws FileNotFoundException {
		
		//using try with resources
		try (BufferedInputStream bufferedIpFile = new BufferedInputStream(new FileInputStream("C:\\tmp\\fileToCopy.txt"));
				BufferedOutputStream bufferedOpFile = new BufferedOutputStream( new FileOutputStream("C:\\tmp\\file.txt"))) {
			byte[] byteRead= new byte[4000];
			int numBytesRead;
			double startTime = System.nanoTime();
			while ((numBytesRead = bufferedIpFile.read(byteRead)) != -1) { //while reading we put to buffer and then read from buffer
				bufferedOpFile.write(byteRead,0,numBytesRead);
			}
			double endTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time = " + endTime / 1000000 + "msec");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
