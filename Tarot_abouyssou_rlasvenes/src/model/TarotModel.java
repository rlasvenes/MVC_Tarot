package model;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TarotModel extends Observable {
	
	private static final DateFormat df = new SimpleDateFormat("[(dd/MM/yyyy) | HH:mm:ss.SSS] ");

	private final static String EXTENSION = ".log";
	public final static Logger LOGGER = Logger.getLogger(TarotModel.class.getName());
	private static Handler h;
	
	protected final int NB_CARDS 	= 74;
	protected final int NB_PLAYER 	= 4;
	
	public TarotModel() {
		try {
			h = new FileHandler("logs/" + TarotModel.class.getName() + EXTENSION);
			h.setFormatter(new SimpleFormatter() {
				public String format(LogRecord record) {
					return record.getLevel() + "  \t:  ["
				         + record.getSourceClassName() + "] ["
				         + record.getSourceMethodName() + "] "
				         + df.format(new Date(record.getMillis())) + " : "
				         + record.getMessage() + "\n";
				}
			});
			LOGGER.addHandler(h);
			LOGGER.log(Level.INFO, "Ajout au Logger du FileHandler : " + LOGGER.getName() + EXTENSION);
			LOGGER.log(Level.INFO, "Penser à faire une classe perso pour avoir son propre Logger et rendre le code "
								 + "plus propre et lisible.");
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {		
		
	}

}
