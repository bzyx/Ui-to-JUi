/********************************************************************************
 ** Form generated from reading ui file 'widget.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.7.0
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package pl.bzyx;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_widget implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QGridLayout gridLayout;
    public QLabel label;
    public QLineEdit file1Name;
    public QPushButton open1File;
    public QLabel label_2;
    public QLineEdit file2Name;
    public QPushButton open2File;
    public QHBoxLayout horizontalLayout;
    public QRadioButton file1to2;
    public QRadioButton file2to1;
    public QPushButton convert;

    public Ui_widget() { super(); }

    public void setupUi(QWidget widget)
    {
        widget.setObjectName("widget");
        widget.resize(new QSize(546, 140).expandedTo(widget.minimumSizeHint()));
        verticalLayout = new QVBoxLayout(widget);
        verticalLayout.setObjectName("verticalLayout");
        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(widget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        file1Name = new QLineEdit(widget);
        file1Name.setObjectName("file1Name");

        gridLayout.addWidget(file1Name, 0, 1, 1, 1);

        open1File = new QPushButton(widget);
        open1File.setObjectName("open1File");

        gridLayout.addWidget(open1File, 0, 2, 1, 1);

        label_2 = new QLabel(widget);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 1, 0, 1, 1);

        file2Name = new QLineEdit(widget);
        file2Name.setObjectName("file2Name");

        gridLayout.addWidget(file2Name, 1, 1, 1, 1);

        open2File = new QPushButton(widget);
        open2File.setObjectName("open2File");

        gridLayout.addWidget(open2File, 1, 2, 1, 1);


        verticalLayout.addLayout(gridLayout);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        file1to2 = new QRadioButton(widget);
        file1to2.setObjectName("file1to2");

        horizontalLayout.addWidget(file1to2);

        file2to1 = new QRadioButton(widget);
        file2to1.setObjectName("file2to1");

        horizontalLayout.addWidget(file2to1);


        verticalLayout.addLayout(horizontalLayout);

        convert = new QPushButton(widget);
        convert.setObjectName("convert");

        verticalLayout.addWidget(convert);

        retranslateUi(widget);

        widget.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget widget)
    {
        widget.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("widget", "Form", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Plik 1", null));
        open1File.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Otw\u00f3rz", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Plik 2", null));
        open2File.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Otw\u00f3rz", null));
        file1to2.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Plik1 -> Plik 2", null));
        file2to1.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Plik 2 -> Plik 1", null));
        convert.setText(com.trolltech.qt.core.QCoreApplication.translate("widget", "Konwertuj", null));
    } // retranslateUi

}

