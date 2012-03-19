package pl.bzyx;

import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QIODevice;
import com.trolltech.qt.core.QTextStream;
import com.trolltech.qt.gui.*;

public class widget extends QWidget {

	Ui_widget ui = new Ui_widget();

	public static void main(String[] args) {
		QApplication.initialize(args);

		widget testwidget = new widget();
		testwidget.show();

		QApplication.exec();
	}

	public widget() {
		ui.setupUi(this);
		initSignalsSlots();
	}

	public widget(QWidget parent) {
		super(parent);
		ui.setupUi(this);
		initSignalsSlots();
	}

	private void initSignalsSlots() {
		ui.open1File.clicked.connect(this, "openFile1()");
		ui.open2File.clicked.connect(this, "openFile2()");
		ui.convert.clicked.connect(this, "convertFiles()");
	}

	@SuppressWarnings("unused")
	private void openFile1() {
		String fileName = openFileType(tr("Ui files (*.ui)"));
		ui.file1Name.setText(fileName);
	}

	@SuppressWarnings("unused")
	private void openFile2() {
		String fileName = openFileType(tr("JUi files (*.jui)"));
		ui.file2Name.setText(fileName);
	}

	@SuppressWarnings("unused")
	private void convertFiles() {
		//if (ui.file1Name.text().trim().isEmpty() || ui.file2Name.text().trim().isEmpty()) {
			if (ui.file1to2.isChecked()) {
				// Konwersja .ui na .jui
				convertUiToJUi();
				return;
			} else if (ui.file2to1.isChecked()) {
				// Konwersja .jui na .ui
				convertJUiToUi();
				return;
			} else {
				QMessageBox.warning(this, "Błąd", "Należy wybrać 1 opcję.");
			}
		//}
	}

	private String openFileType(String fileFilter) {
		String file = null;
		QFileDialog dialog = new QFileDialog(this,
				"Podaj nazwę pliku do otwarcia");
		dialog.setFilter(fileFilter);
		if (dialog.exec() > 0)
			file = dialog.selectedFiles().get(0);
		return file;
	}
	
	private void convertUiToJUi() {
		QFile file1 = new QFile(ui.file1Name.text().trim());
		if ( !file1.open(QIODevice.OpenModeFlag.ReadOnly) ){
			return;
		}
		
		QFile file2 = new QFile(ui.file2Name.text().trim());
		if ( !file2.open(QIODevice.OpenModeFlag.WriteOnly) ){;
			return;
		}
		
		QTextStream in = new QTextStream(file1);
		QTextStream out = new QTextStream(file2);
		while(!in.atEnd()){
			String line = in.readLine();
			if ( line.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>") ){
				line = "";
				continue;
			}
			if ( line.startsWith("<ui version=\"4.0\">") ){
				line = "<ui version=\"4.0\" language=\"jambi\">";
			}
			out.writeString(line+"\n");
		}
		out.flush();
		file2.close();
		file1.close();
	}

	
	private void convertJUiToUi() {
		QFile file1 = new QFile(ui.file1Name.text().trim());
		if ( !file1.open(QIODevice.OpenModeFlag.WriteOnly) ){
			return;
		}
		
		QFile file2 = new QFile(ui.file2Name.text().trim());
		if ( !file2.open(QIODevice.OpenModeFlag.ReadOnly) ){;
			return;
		}
		
		QTextStream in = new QTextStream(file2);
		QTextStream out = new QTextStream(file1);
		
		//First line
		out.writeString("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		while(!in.atEnd()){
			String line = in.readLine();
			if ( line.startsWith("<ui version=\"4.0\" language=\"jambi\">") ){
				line = "<ui version=\"4.0\">";
			}
			out.writeString(line+"\n");
		}
		out.flush();
		file1.close();
		file2.close();
	}

}
