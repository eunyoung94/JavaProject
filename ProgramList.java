package project;

import javax.swing.table.AbstractTableModel;

public class ProgramList extends AbstractTableModel {
   String[][] data = {};
   String[] column = { "번호", "프로그램명", "요일", "시작일", "종료일", "금액","최대인원" };

   @Override
   public int getColumnCount() {
      return column.length;
   }

   public int getRowCount() {
      return data.length;
   }

   public String getColumnName(int col) {
      return column[col];
   }

   public Object getValueAt(int row, int col) {
      return data[row][col];
   }

}