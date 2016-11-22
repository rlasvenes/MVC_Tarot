package ressources;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.MyLogger;

public class Tests {
	
	public static void main(String[] args) throws SecurityException, IOException {
		Logger logger = MyLogger.getLogger();
		logger.log(Level.INFO, "Running test from Tests.java class !");
	}
}
