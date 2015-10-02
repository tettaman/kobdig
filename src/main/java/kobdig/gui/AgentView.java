/*
 * AgentView.java
 *
 * Created on June 26, 2008, 11:06 AM
 */

package kobdig.gui;

import kobdig.agent.Agent;
import kobdig.agent.Fact;
import kobdig.logic.TruthDegree;

/**
 * A view of a KOBDIG agent.
 *
 * @author  Andrea G. B. Tettamanzi
 */
public class AgentView extends javax.swing.JFrame
{
    /** The agent whose this window is a view. */
    Agent agent;

    /**
     * Creates new agent view.
     */
    public AgentView(Agent a)
    {
        agent = a;
        initComponents();
        setTitle(a.name());
        update();
        log("Agent initialized.");
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        tabbedPane = new javax.swing.JTabbedPane();
        kScrollPane = new javax.swing.JScrollPane();
        knowledge = new javax.swing.JTextArea();
        bScrollPane = new javax.swing.JScrollPane();
        beliefs = new javax.swing.JTextArea();
        oRulesScrollPane = new javax.swing.JScrollPane();
        obligationRules = new javax.swing.JTextArea();
        dRulesScrollPane = new javax.swing.JScrollPane();
        desireRules = new javax.swing.JTextArea();
        oScrollPane = new javax.swing.JScrollPane();
        obligations = new javax.swing.JTextArea();
        dScrollPane = new javax.swing.JScrollPane();
        desires = new javax.swing.JTextArea();
        gScrollPane = new javax.swing.JScrollPane();
        goals = new javax.swing.JTextArea();
        logScrollPane = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        actionMenu = new javax.swing.JMenu();
        updateBeliefs = new javax.swing.JMenuItem();
        close = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        knowledge.setColumns(20);
        knowledge.setRows(5);
        kScrollPane.setViewportView(knowledge);

        tabbedPane.addTab(" K ", kScrollPane);

        beliefs.setColumns(20);
        beliefs.setRows(5);
        bScrollPane.setViewportView(beliefs);

        tabbedPane.addTab(" B ", bScrollPane);

        obligationRules.setColumns(20);
        obligationRules.setRows(5);
        oRulesScrollPane.setViewportView(obligationRules);

        tabbedPane.addTab("O-rules", oRulesScrollPane);

        desireRules.setColumns(20);
        desireRules.setRows(5);
        dRulesScrollPane.setViewportView(desireRules);

        tabbedPane.addTab("D-rules", dRulesScrollPane);

        obligations.setColumns(20);
        obligations.setRows(5);
        oScrollPane.setViewportView(obligations);

        tabbedPane.addTab(" O ", oScrollPane);

        desires.setColumns(20);
        desires.setRows(5);
        dScrollPane.setViewportView(desires);

        tabbedPane.addTab(" D ", dScrollPane);

        goals.setColumns(20);
        goals.setRows(5);
        gScrollPane.setViewportView(goals);

        tabbedPane.addTab(" G ", gScrollPane);

        splitPane.setTopComponent(tabbedPane);

        log.setColumns(20);
        log.setRows(5);
        logScrollPane.setViewportView(log);

        splitPane.setRightComponent(logScrollPane);

        actionMenu.setText("Action");

        updateBeliefs.setText("New Belief...");
        updateBeliefs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBeliefs(evt);
            }
        });
        actionMenu.add(updateBeliefs);

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close(evt);
            }
        });
        actionMenu.add(close);

        menuBar.add(actionMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Close the agent view.
     * 
     * @param evt
     */
private void close(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close
        dispose();
}//GEN-LAST:event_close

/**
 * Let the user provide a propositional formula and a degree of
 * trust for the agent to update its beliefs.
 * 
 * @param evt
 */
private void updateBeliefs(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBeliefs
    // TODO add your handling code here:
    // 1. show a dialog
    FormulaInputDialog dialog = new FormulaInputDialog(this);
    assert(dialog.isModal());
    dialog.setVisible(true);
    Fact fact = dialog.getFact();
    if(fact==null)
        // User cancelled the operation.
        return;
    // 2. pass the provided formula to the agent.
    TruthDegree trust = dialog.getTrust();
    agent.updateBeliefs(fact, trust);
    update();
    log("Revised beliefs with new information " + fact.formula() +
            ", trusted to the degree " + trust + ".");
}//GEN-LAST:event_updateBeliefs

    /**
     * Updates the view to reflect the current status of the associated agent.
     */
    public void update()
    {
        knowledge.setText(agent.knowledge().toString());
        beliefs.setText(agent.beliefs().toString());
        obligationRules.setText(agent.obligationRules().toString());
        desireRules.setText(agent.desireRules().toString());
        obligations.setText(agent.obligations().toString());
        // desires.setText(agent.desires().toString());
        desires.setText(agent.utility().toString());
        goals.setText(agent.goals().toString());
    }

    /**
     * Display a message in the log pane, in the bottom half of the window.
     */
    protected void log(String msg)
    {
        log.setText(log.getText() + msg + "\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu actionMenu;
    private javax.swing.JScrollPane bScrollPane;
    private javax.swing.JTextArea beliefs;
    private javax.swing.JMenuItem close;
    private javax.swing.JScrollPane dRulesScrollPane;
    private javax.swing.JScrollPane dScrollPane;
    private javax.swing.JTextArea desireRules;
    private javax.swing.JTextArea desires;
    private javax.swing.JScrollPane gScrollPane;
    private javax.swing.JTextArea goals;
    private javax.swing.JScrollPane kScrollPane;
    private javax.swing.JTextArea knowledge;
    private javax.swing.JTextArea log;
    private javax.swing.JScrollPane logScrollPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JScrollPane oRulesScrollPane;
    private javax.swing.JScrollPane oScrollPane;
    private javax.swing.JTextArea obligationRules;
    private javax.swing.JTextArea obligations;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JMenuItem updateBeliefs;
    // End of variables declaration//GEN-END:variables

}