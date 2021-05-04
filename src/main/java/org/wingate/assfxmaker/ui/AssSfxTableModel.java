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
package org.wingate.assfxmaker.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import org.wingate.assfxmaker.ass.ASS;
import org.wingate.assfxmaker.ass.AssEvent;
import org.wingate.assfxmaker.ass.AssEvent.LineType;
import org.wingate.assfxmaker.ass.AssStyle;
import org.wingate.timelibrary.Time;

/**
 *
 * @author util2
 */
public class AssSfxTableModel extends javax.swing.table.AbstractTableModel {
    
    private ASS ass = ASS.NoFileToLoad();
    private TextMode textMode = TextMode.Raw;
    
    public AssSfxTableModel(){
        
    }

    public ASS getAss() {
        return ass;
    }

    public void setAss(ASS ass) {
        this.ass = ass;
    }
    
    public void insertAll(List<AssEvent> events){
        for(int i=0; i<events.size(); i++){
            ass.getEvents().add(events.get(i));
        }
    }
    
    public void insertOne(AssEvent ev){
        ass.getEvents().add(ev);
    }
    
    public void insertOneAt(AssEvent ev, int index){
        ass.getEvents().add(index, ev);
    }
    
    public void removeAll(){
        ass.getEvents().clear();
    }
    
    public void removeOne(AssEvent ev){
        String wanted = AssEvent.getAssEventLine(ev);
        int lineINDEX = -1;
        for(int i=0; i< ass.getEvents().size(); i++){
            String rawlineFromModel = AssEvent.getAssEventLine(ass.getEvents().get(i));
            if(rawlineFromModel.equals(wanted) == true){
                lineINDEX = i;
                break;
            }
        }
        if(lineINDEX != -1){
            ass.getEvents().remove(lineINDEX);
        }
    }
    
    public void removeOne(int index){
        if(index < getRowCount() && index > -1){
            ass.getEvents().remove(index);
        }
    }
    
    public AssEvent getEventAt(int row){
        return ass.getEvents().get(row);
    }
    
    public List<AssEvent> getAllEvents(){
        return new ArrayList<>(ass.getEvents());
    }
    
    public List<AssEvent> getSelectedEvents(JTable table){
        List<AssEvent> list = new ArrayList<>();
        
        int[] selected = table.getSelectedRows();
        
        for(int i=0; i<selected.length; i++){
            list.add(ass.getEvents().get(selected[i]));
        }
        
        return list;
    }
    
    public void changeEventAt(AssEvent newEvent, int row){
        ass.getEvents().add(row + 1, newEvent);
        ass.getEvents().remove(row);
    }
    
    // Index 0 -> Line number
    public int getLineNumber(int row){
        return row + 1;
    }
    
    // Index 1 -> Line type
    public LineType getLineType(int row){
        return ass.getEvents().get(row).getLineType();
    }
    
    // Index 2 -> Layer
    public int getLayer(int row){
        return ass.getEvents().get(row).getLayer();
    }
    
    // Index 3 -> Start time
    public Time getStartTime(int row){
        return ass.getEvents().get(row).getStartTime();
    }
    
    // Index 4 -> End time
    public Time getEndTime(int row){
        return ass.getEvents().get(row).getEndTime();
    }
    
    // Index 5 -> Margin L
    public int getMarginL(int row){
        return ass.getEvents().get(row).getMarginL();
    }
    
    // Index 6 -> Margin R
    public int getMarginR(int row){
        return ass.getEvents().get(row).getMarginR();
    }
    
    // Index 7 -> Margin V
    public int getMarginV(int row){
        return ass.getEvents().get(row).getMarginV();
    }
    
    // Index 8 -> Style name
    public AssStyle getStyle(int row){        
        return ass.getEvents().get(row).getStyle();
    }
    
    // Index 9 -> Name or Actor
    public String getName(int row){
        return ass.getEvents().get(row).getName();
    }
    
    // Index 10 -> Effect
    public String getEffect(int row){
        return ass.getEvents().get(row).getEffect();
    }
    
    // Index 11 -> CPL
    public int getHelpCPL(int row){
        return Help.getCPL(ass.getEvents().get(row).getText());
    }
    
    // Index 12 -> CPS
    public int getHelpCPS(int row){
        Time start = ass.getEvents().get(row).getStartTime();
        Time end = ass.getEvents().get(row).getEndTime();
        String text = ass.getEvents().get(row).getText();
        return Help.getCPS(start, end, text);
    }
    
    // Index 13 -> Text
    public String getText(int row){
        return ass.getEvents().get(row).getText();
    }
    
    static class Help {        
        public static int getCPL(String text){
            String[] pieces = text.split("\\\\N");
            int max = -1;
            for(String piece : pieces){
                max = Math.max(max, piece.length());
            }
            return max;
        }
        
        public static int getCPS(Time s, Time e, String text){
            Time dur = Time.substract(s, e);
            String ref = text.replaceAll("\\\\N", "").replaceAll(" ", "");
            int duration = (int)Time.getLengthInSeconds(dur);
            return duration == 0 ? ref.length() : ref.length() / duration;
        }
    }
    
    @Override
    public int getRowCount() {
        return ass.getEvents().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0 -> { return ass.getEvents().get(row).getLineType(); }
            case 1 -> { return ass.getEvents().get(row).getLayer(); }
            case 2 -> { return setTextMode(ass.getEvents().get(row), textMode); }
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0 -> { return LineType.class; }
            case 1 -> { return Integer.class; }
            case 2 -> { return String.class; }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 -> { return "Type"; }
            case 1 -> { return "Layer"; }
            case 2 -> { return "Text"; }
        }
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public void setColumnSize(JTable table){
        final TableColumnModel tblColumnModel = table.getColumnModel();
        int maxTableWidth = table.getWidth();
        
        tblColumnModel.getColumn(0).setPreferredWidth(40); maxTableWidth -= 40; // Type
        tblColumnModel.getColumn(1).setPreferredWidth(40); maxTableWidth -= 40; // Layer
        tblColumnModel.getColumn(2).setPreferredWidth(maxTableWidth); // Text
    }
    
    public enum TextMode {
        Raw, Tag, TextOnly;
    }

    public TextMode getTextMode() {
        return textMode;
    }

    public void setTextMode(TextMode textMode) {
        this.textMode = textMode;
    }
    
    private String setTextMode(AssEvent ev, TextMode tm){
        if(ev.getText().contains("{") == true){
            switch(tm){
                case Tag -> {
                    Pattern p = Pattern.compile("\\{([^\\}]+)\\}([^\\{]+)");
                    Matcher m = p.matcher(ev.getText());

                    StringBuilder sb = new StringBuilder();
                    while(m.find()){
                        sb.append("|");
                        sb.append(m.group(2));
                    }
                    return sb.toString();
                }
                case TextOnly -> {
                    Pattern p = Pattern.compile("\\{([^\\}]+)\\}([^\\{]+)");
                    Matcher m = p.matcher(ev.getText());

                    StringBuilder sb = new StringBuilder();
                    while(m.find()){
                        sb.append(m.group(2));
                    }
                    return sb.toString();
                }
            }
        }        
        return ev.getText();
    }
}
