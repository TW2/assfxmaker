/*
 * Copyright (C) 2021 util2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.wingate.assfxmaker.sfx;

/**
 *
 * @author util2
 */
public class AfmLegacy {

    public enum Type {
        AFM("AFMO"),
        Ruby("Ruby"),
        Python("Python"),
        JavaScript("JS"),
        Lua("Lua");
        
        String sfxType;
        
        private Type(String sfxType){
            this.sfxType = sfxType;
        }

        public String getSfxType() {
            return sfxType;
        }

        @Override
        public String toString() {
            return sfxType;
        }
        
        public static Type get(String s){
            Type sfx = AFM;
            
            for(Type type : values()){
                if(type.getSfxType().equalsIgnoreCase(s) == true){
                    sfx = type;
                    break;
                }
            }
            
            return sfx;
        }
    }
    
    private Type type = Type.AFM;
    private String code = "";
    private String name = "Unknown effect";
    private String author = "Unknown author";
    private String version = "v1.0";
    private String description = "No description";

    public AfmLegacy() {
    }
    
    public AfmLegacy(Type type, String code, String name, String author, String version, String description) {
        this.type = type;
        this.code = code;
        this.name = name;
        this.author = author;
        this.version = version;
        this.description = description;
    }
    
    public AfmLegacy(Type type, String name, String author, String version, String description) {
        this.type = type;
        this.name = name;
        this.author = author;
        this.version = version;
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
