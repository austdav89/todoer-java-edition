/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoer;

import java.time.OffsetDateTime;

/**
 *
 * @author austind
 */
public class Todo {
    public boolean  done;
    public String   name;
    public String   note;
    public OffsetDateTime created;
    
    public Todo(String n){
        name = n;
    }
    
}
