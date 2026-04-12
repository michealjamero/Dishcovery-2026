package com.toedter.calendar;

public class JDateChooser extends javax.swing.JPanel {

    private final javax.swing.JSpinner spinner;

    public JDateChooser() {
        java.util.Date now = new java.util.Date();
        spinner = new javax.swing.JSpinner(new javax.swing.SpinnerDateModel(now, null, null, java.util.Calendar.DAY_OF_MONTH));
        spinner.setEditor(new javax.swing.JSpinner.DateEditor(spinner, "MMM d, yyyy"));
        setLayout(new java.awt.BorderLayout());
        add(spinner, java.awt.BorderLayout.CENTER);
    }

    public java.util.Date getDate() {
        Object v = spinner.getValue();
        return v instanceof java.util.Date ? (java.util.Date) v : null;
    }

    public void setDate(java.util.Date date) {
        if (date == null) {
            date = new java.util.Date();
        }
        spinner.setValue(date);
    }

    public void setDateFormatString(String s) {
    }
}

