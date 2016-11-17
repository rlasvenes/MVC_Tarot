package model;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TarotModel extends Observable {
	
	private final static Logger LOGGER = Logger.getLogger(TarotModel.class.getName());
	private static Handler h;
	
	protected final int NB_CARDS 	= 74;
	protected final int NB_PLAYER 	= 4;
	
	public static void main(String[] args) {		
		try {
			h = new FileHandler("logs/" + TarotModel.class.getName() + ".log");
			h.setFormatter(new SimpleFormatter() {
				public String format(LogRecord record) {
					return record.getLevel() + "  : ["
				         + record.getSourceClassName() + "] -:- ["
				         + record.getSourceMethodName() + "] -:- "
				         + record.getMessage() + "\n";
				}
			});
			LOGGER.addHandler(h);
			LOGGER.log(Level.WARNING, "Initialisation du handler");
			LOGGER.severe("Erreur lors de l'initialisation ! ");
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
