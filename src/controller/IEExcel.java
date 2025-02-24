package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IEExcel {
	public static void exportExcel(JTable table, String tenSheet) {
		try {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.showSaveDialog(null);
			File saveFile = jFileChooser.getSelectedFile();
			if (saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet(tenSheet);

				Row rowCol = sheet.createRow(0);
				for (int i = 0; i < table.getColumnCount(); i++) {
					Cell cell = rowCol.createCell(i);
					cell.setCellValue(table.getColumnName(i));
				}

				for (int j = 0; j < table.getRowCount(); j++) {
					Row row = sheet.createRow(j + 1);
					for (int k = 0; k < table.getColumnCount(); k++) {
						Cell ce = row.createCell(k);
						if (table.getValueAt(j, k) != null) {
							ce.setCellValue(table.getValueAt(j, k).toString());
						}

					}
				}
				FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
				wb.write(out);
				wb.close();
				out.close();
				openFile(saveFile.toString());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	private static void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
