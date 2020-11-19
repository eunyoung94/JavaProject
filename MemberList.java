package project;

import javax.swing.table.AbstractTableModel;

public class MemberList extends AbstractTableModel{
	String[][]data = {};
	String[]column = {"회원번호","이름","나이","성별","전화번호","메일","주소","등록일","만기일"};
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
