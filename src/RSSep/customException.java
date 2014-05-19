package RSSep;
/**
 * 
 * @author Capokantil
 *
 */
public class customException extends Exception
{
      /**
       *  Constructor without parameter
       */
      public customException() {}

      /**
       * Constructor that accepts a message
       * @param message
       */
      public customException(String message)
      {
         super(message);
      }
 }

