
package db;

/**
 *
 * @author Shelton Francisco
 */
public class DbIntegrityException extends RuntimeException{
    
    public DbIntegrityException(String msg){
        super(msg);
    }
}
