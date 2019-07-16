package dashboard.main;

import java.awt.Event;

import javafx.event.*;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Utility.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UIController implements Initializable {

	private double xOffset = 0;
	private double yOffset = 0;
	@FXML
	private AnchorPane parent;

	@FXML
	private VBox vbox;
	@FXML
	private HBox dashboard;
	@FXML
	private HBox prisonerhandle;
	@FXML
	private HBox criminals;
	@FXML
	private HBox suspects;
	@FXML
	private HBox victims;

	@FXML
	private AnchorPane prisoneranch;
	@FXML
	private AnchorPane criminalanch;
	@FXML
	private AnchorPane victimanch;
	@FXML
	private AnchorPane suspectanch;

		
	@FXML 
	private ProgressIndicator com_cases;
	@FXML
	private ProgressIndicator run_cases;
	@FXML
	private ProgressIndicator total_cases;
	@FXML
	private Label com_label;
	@FXML
	private Label run_label;
	@FXML
	private Label total_label;
	/************************************
	Victim 
	*************************************/
	@FXML 
	private TableView<VictimTable> victim_table;
	@FXML
	private TableColumn<VictimTable,String> victim_id;
	@FXML
	private TableColumn<VictimTable,String> v_fname;
	@FXML
	private TableColumn<VictimTable,String> v_lname;
	@FXML
	private TableColumn<VictimTable,String> v_gen;
	@FXML
	private TableColumn<VictimTable,String> v_age;
	@FXML
	private TableColumn<VictimTable,String> v_mobile;
	@FXML
	private TableColumn<VictimTable,String> v_case_id;
	
	@FXML 
	private TableView<VictimTable> victim_table1;
	@FXML
	private TableColumn<VictimTable,String> v_id1;
	@FXML
	private TableColumn<VictimTable,String> v_fname1;
	@FXML
	private TableColumn<VictimTable,String> v_lname1;
	@FXML
	private TableColumn<VictimTable,String> v_gen1;
	@FXML
	private TableColumn<VictimTable,String> v_age1;
	@FXML
	private TableColumn<VictimTable,String> v_mobile1;
	@FXML
	private TableColumn<VictimTable,String> v_case_id1;
	

	@FXML
	private JFXTextField vtext_id;
	@FXML 
	private JFXTextField vtext_fname;
	@FXML
	private JFXTextField vtext_lname;
	@FXML 
	private JFXTextField vtext_gen;
	@FXML
	private JFXTextField vtext_caseid;
	@FXML 
	private JFXTextField vtext_age;
	@FXML 
	private JFXTextField vtext_mobile;
	

	@FXML
	private JFXButton victim_submit;
	@FXML
	private JFXButton victim_reset;
	
	@FXML
	private Tab victim_over;
	
	//Search in Victim TextField
	@FXML
	private JFXTextField vstext_fname;
	@FXML 
	private JFXTextField vstext_lname;
	@FXML
	private JFXButton victim_search;
	
	
	/************************************
	Suspect
	*************************************/
	@FXML 
	private TableView <SuspectTable> suspect_table;
	@FXML
	private TableColumn<SuspectTable,String> sid;
	@FXML
	private TableColumn<SuspectTable,String> fname;
	@FXML
	private TableColumn<SuspectTable,String> lname;
	@FXML
	private TableColumn<SuspectTable,String> gen;
	@FXML
	private TableColumn<SuspectTable,String> age;
	@FXML
	private TableColumn<SuspectTable,String> mobile;
	@FXML
	private TableColumn<SuspectTable,String> case_id;
	@FXML
	private TableColumn<SuspectTable,String> crime_id;
	
	@FXML 
	private TableView <SuspectTable> suspect_table1;
	@FXML
	private TableColumn<SuspectTable,String> sid1;
	@FXML
	private TableColumn<SuspectTable,String> fname1;
	@FXML
	private TableColumn<SuspectTable,String> lname1;
	@FXML
	private TableColumn<SuspectTable,String> gen1;
	@FXML
	private TableColumn<SuspectTable,String> age1;
	@FXML
	private TableColumn<SuspectTable,String> mobile1;
	@FXML
	private TableColumn<SuspectTable,String> case_id1;
	@FXML
	private TableColumn<SuspectTable,String> crime_id1;
	
	@FXML
	private JFXTextField stext_id;
	@FXML 
	private JFXTextField stext_fname;
	@FXML
	private JFXTextField stext_lname;
	@FXML 
	private JFXTextField stext_gen;
	@FXML
	private JFXTextField stext_caseid;
	@FXML 
	private JFXTextField stext_age;
	@FXML 
	private JFXTextField stext_mobile;
	@FXML
	private JFXTextField stext_crimeid;
	@FXML
	private JFXButton suspect_submit;
	@FXML
	private JFXButton suspect_reset;
	@FXML
	private Tab suspect_over;
	
	//Search in Suspect TextField
		@FXML
		private JFXTextField sstext_fname;
		@FXML 
		private JFXTextField sstext_lname;
		@FXML
		private JFXButton suspect_search;
	
	/************************************
	Criminal
	*************************************/
		@FXML
		private TableView <CriminalTable> criminal_table;
		@FXML
		private TableColumn<CriminalTable,String> col_cid;
		@FXML
		private TableColumn<CriminalTable,String> col_fname;
		@FXML
		private TableColumn<CriminalTable,String> col_lname;
		@FXML
		private TableColumn<CriminalTable,String> col_gen;
		@FXML
		private TableColumn<CriminalTable,String> col_age;
		@FXML
		private TableColumn<CriminalTable,String> col_mob;
		@FXML
		private TableColumn<CriminalTable,String> col_caseid;
		@FXML
		private TableColumn<CriminalTable,String> col_status;
		@FXML
		private TableColumn<CriminalTable,String> col_release;
		
		@FXML
		private TableView <CriminalTable> criminal_table1;
		@FXML
		private TableColumn<CriminalTable,String> col_cid1;
		@FXML
		private TableColumn<CriminalTable,String> col_fname1;
		@FXML
		private TableColumn<CriminalTable,String> col_lname1;
		@FXML
		private TableColumn<CriminalTable,String> col_gen1;
		@FXML
		private TableColumn<CriminalTable,String> col_age1;
		@FXML
		private TableColumn<CriminalTable,String> col_mob1;
		@FXML
		private TableColumn<CriminalTable,String> col_caseid1;
		@FXML
		private TableColumn<CriminalTable,String> col_status1;
		@FXML
		private TableColumn<CriminalTable,String> col_release1;
		
		
	@FXML
	private JFXTextField crtext_id;
	@FXML 
	private JFXTextField crtext_fname;
	@FXML
	private JFXTextField crtext_lname;
	@FXML 
	private JFXTextField crtext_gen;
	@FXML
	private JFXTextField crtext_caseid;
	@FXML 
	private JFXTextField crtext_age;
	@FXML 
	private JFXTextField crtext_mobile;
	@FXML
	private JFXComboBox<String> crtext_status;
	
	@FXML
	private JFXDatePicker crtext_date;
	@FXML
	private JFXButton criminal_submit;
	@FXML
	private JFXButton criminal_reset;
	@FXML
	private Tab criminal_over;
	//Search in Criminal TextField
			@FXML
			private JFXTextField crstext_id;
			@FXML 
			private JFXTextField crstext_fname;
			@FXML
			private JFXTextField crstext_caseid;
			@FXML
			private JFXButton criminal_search;
		
	
	
	
	/************************************
	Cases
	*************************************/
	@FXML
	private TableView <CaseTable> case_table;
	@FXML
	private TableColumn<CaseTable,String> caseid;
	@FXML
	private TableColumn<CaseTable,String> col_area;
	@FXML
	private TableColumn<CaseTable,String> desc;
	@FXML
	private TableColumn<CaseTable,String> act;
	@FXML
	private TableColumn<CaseTable,String> victim;
	@FXML
	private TableColumn<CaseTable,String> suspect;
	@FXML
	private TableColumn<CaseTable,String> date;
	@FXML
	private TableColumn<CaseTable,String> status;
	
	@FXML
	private TableView <CaseTable> case_table1;
	@FXML
	private TableColumn<CaseTable,String> caseid1;
	@FXML
	private TableColumn<CaseTable,String> col_area1;
	@FXML
	private TableColumn<CaseTable,String> desc1;
	@FXML
	private TableColumn<CaseTable,String> act1;
	@FXML
	private TableColumn<CaseTable,String> victim1;
	@FXML
	private TableColumn<CaseTable,String> suspect1;
	@FXML
	private TableColumn<CaseTable,String> date1;
	@FXML
	private TableColumn<CaseTable,String> status1;
	
	
	
	@FXML
	private JFXTextField ctext_id;
	@FXML 
	private JFXTextField ctext_area;
	@FXML
	private JFXTextArea ctext_desc;
	@FXML 
	private JFXTextField ctext_act;
	@FXML
	private JFXTextField ctext_victim;
	@FXML 
	private JFXTextField ctext_suspect;
	@FXML
	private JFXComboBox ctext_status;
	@FXML
	private JFXDatePicker ctext_date;
	
	
	@FXML
	private JFXButton case_submit;
	@FXML
	private JFXButton case_reset;
	
	
	//Search in Suspect TextField
			@FXML
			private JFXTextField cstext_id;
			@FXML 
			private JFXTextField cstext_area;
			@FXML
			private JFXDatePicker cstext_date;
			@FXML
			private JFXButton case_search;
			
	//For Bar Chart
	
	@FXML
	private BarChart bar;
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		
		prisoneranch.setVisible(false);
		criminalanch.setVisible(false);
		
		victimanch.setVisible(false);
		vbox.setVisible(true);
		barChart();
		progressBar();
		crtext_status.getItems().addAll("In Jail","Released");
		ctext_status.getItems().addAll("In Jail","Released");
		makeStageDrageable();
		dashboard.setOnMouseClicked(this::handleDash);
		prisonerhandle.setOnMouseClicked(this::handleprisoner);
		suspects.setOnMouseClicked(this::handleSuspect);
		criminals.setOnMouseClicked(this::handleCriminal);
		victims.setOnMouseClicked(this::handleVictim);
		
		victim_submit.setOnMouseClicked(this::insert_victim);
		victim_search.setOnMouseClicked(this::search_victim);
			
		suspect_submit.setOnMouseClicked(this::insert_suspect);
		suspect_search.setOnMouseClicked(this::search_suspect);
		
		criminal_submit.setOnMouseClicked(this::insert_criminal);
		criminal_search.setOnMouseClicked(this::search_criminal);
		
		case_submit.setOnMouseClicked(this::insert_case);
		case_search.setOnMouseClicked(this::search_case);
		
		victim_reset.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				victim_reset(event);
			}
		});;
		suspect_reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				suspect_reset(event);
			}
		});;
		criminal_reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				criminal_reset(event);
			}
		});;
		case_reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				case_reset(event);
			}
		});;

		}



	private void makeStageDrageable() {
		parent.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Launch.stage.setX(event.getScreenX() - xOffset);
				Launch.stage.setY(event.getScreenY() - yOffset);
				Launch.stage.setOpacity(0.7f);
			}
		});
		parent.setOnDragDone((e) -> {
			Launch.stage.setOpacity(1.0f);
		});
		parent.setOnMouseReleased((e) -> {
			Launch.stage.setOpacity(1.0f);
		});

	}
	public void handleDash (MouseEvent e)
	{
		suspectanch.setVisible(false);
		prisoneranch.setVisible(false);
		criminalanch.setVisible(false);
		victimanch.setVisible(false);
		vbox.setVisible(true);
	}
	public void handleprisoner (MouseEvent e)
	{
		suspectanch.setVisible(false);
		vbox.setVisible(false);
		criminalanch.setVisible(false);
		victimanch.setVisible(false);
		prisoneranch.setVisible(true);
		case_database();
	}
	public void handleCriminal (MouseEvent e)
	{
		suspectanch.setVisible(false);
		vbox.setVisible(false);
		prisoneranch.setVisible(false);
		victimanch.setVisible(false);
		criminalanch.setVisible(true);
		criminal_database();
	}
	public void handleSuspect (MouseEvent e)
	{
		prisoneranch.setVisible(false);
		criminalanch.setVisible(false);
		victimanch.setVisible(false);
		vbox.setVisible(false);
		suspectanch.setVisible(true);
		suspect_database();
	}

	public void handleVictim (MouseEvent e)
	{
		vbox.setVisible(false);
		suspectanch.setVisible(false);
		
		prisoneranch.setVisible(false);
		criminalanch.setVisible(false);
		victimanch.setVisible(true);
		victim_database();
		
	}
	
	public void criminal_database()
	{
		ObservableList<CriminalTable> oblist =FXCollections.observableArrayList();
		try {
			Connection con=DBConnector.getConnection();
			ResultSet rs=con.createStatement().executeQuery("select * from criminal");
			while(rs.next())
			{
				
			
				oblist.add(new CriminalTable(rs.getInt("Criminal_ID"), rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		col_cid.setCellValueFactory(new PropertyValueFactory<>("criminal_id"));
		col_fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
		col_lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
		col_gen.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		col_age.setCellValueFactory(new PropertyValueFactory<>("Age"));
		col_mob.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		col_caseid.setCellValueFactory(new PropertyValueFactory<>("case_id"));
		col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
		col_release.setCellValueFactory(new PropertyValueFactory<>("release_date"));
		criminal_table.setItems(oblist);
	}
	
	public void case_database()
	{
		ObservableList<CaseTable> oblist1 =FXCollections.observableArrayList();
		try {
			Connection con=DBConnector.getConnection();
			ResultSet rs=con.createStatement().executeQuery("select * from fir");
			while(rs.next())
			{
				
				oblist1.add(new CaseTable(rs.getInt(7), rs.getString(8),rs.getString(2),rs.getInt(4),
						rs.getInt(1),rs.getInt(3),rs.getDate(6),rs.getString(5)));
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		caseid.setCellValueFactory(new PropertyValueFactory<>("case_id"));
		col_area.setCellValueFactory(new PropertyValueFactory<>("area"));
		desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
		act.setCellValueFactory(new PropertyValueFactory<>("act"));
		victim.setCellValueFactory(new PropertyValueFactory<>("victim"));
		suspect.setCellValueFactory(new PropertyValueFactory<>("suspect"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		case_table.setItems(oblist1);
	}
	public void suspect_database()
	{
		ObservableList<SuspectTable> oblist2 =FXCollections.observableArrayList();
		try {
			Connection con=DBConnector.getConnection();
			ResultSet rs=con.createStatement().executeQuery("select * from suspect");
			while(rs.next())
			{
				
				oblist2.add(new SuspectTable(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
		fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
		lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
		gen.setCellValueFactory(new PropertyValueFactory<>("gen"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		case_id.setCellValueFactory(new PropertyValueFactory<>("case_id"));
		crime_id.setCellValueFactory(new PropertyValueFactory<>("crime_id"));
		
		suspect_table.setItems(oblist2);
	}
	public void victim_database()
	{
		ObservableList<VictimTable> oblist =FXCollections.observableArrayList();
		try {
			Connection con=DBConnector.getConnection();
			ResultSet rs=con.createStatement().executeQuery("select * from victim");
			while(rs.next())
			{
					
				oblist.add(new VictimTable(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7)));
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		victim_id.setCellValueFactory(new PropertyValueFactory<>("victim_id"));
		v_fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
		v_lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
		v_gen.setCellValueFactory(new PropertyValueFactory<>("gen"));
		v_age.setCellValueFactory(new PropertyValueFactory<>("age"));
		v_mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		v_case_id.setCellValueFactory(new PropertyValueFactory<>("case_id"));
		
		
		victim_table.setItems(oblist);
	}

	
	public void insert_victim(MouseEvent e)
	{
		
		int victim_id1=Integer.parseInt(vtext_id.getText());
		String fname=vtext_fname.getText();
		String lname=vtext_lname.getText();
		String gen=vtext_gen.getText();
		int age=Integer.parseInt(vtext_age.getText());
		int mobile=Integer.parseInt(vtext_mobile.getText());
		int case_id=Integer.parseInt(vtext_caseid.getText());
		String query="insert into victim values(?,?,?,?,?,?,?)";
		
		try {
			
			Connection con=DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1, victim_id1);
		      preparedStmt.setString (2, fname);
		      preparedStmt.setString   (3, lname);
		      preparedStmt.setString(4, gen);
		      preparedStmt.setInt(5, age);
		      preparedStmt.setInt(6, mobile);
		      preparedStmt.setInt(7, case_id);
		      preparedStmt.execute();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		victim_reset(null);
	}
	public void search_victim(MouseEvent e)
	{
		String fname=vstext_fname.getText();
		String lname=vstext_lname.getText();
		String query="select * from victim where fname=? or lname=?";
		ObservableList<VictimTable> oblist =FXCollections.observableArrayList();
		try {
			
			Connection con=DBConnector.getConnection();
			ResultSet rs=null;
			PreparedStatement preparedStmt=con.prepareStatement(query);
			
			preparedStmt.setString (1, fname);
			preparedStmt.setString (2, lname);
		    rs= preparedStmt.executeQuery();
				while(rs.next())
				{
						
					oblist.add(new VictimTable(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getInt(5),rs.getInt(6),rs.getInt(7)));
				}
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		

		v_id1.setCellValueFactory(new PropertyValueFactory<>("victim_id"));
		v_fname1.setCellValueFactory(new PropertyValueFactory<>("fname"));
		v_lname1.setCellValueFactory(new PropertyValueFactory<>("lname"));
		v_gen1.setCellValueFactory(new PropertyValueFactory<>("gen"));
		v_age1.setCellValueFactory(new PropertyValueFactory<>("age"));
		v_mobile1.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		v_case_id1.setCellValueFactory(new PropertyValueFactory<>("case_id"));
		
		victim_table1.setItems(oblist);
		vstext_fname.setText(null);
		vstext_lname.setText(null);
	}
		
	
	public void insert_suspect(MouseEvent e)
	{
		
		int suspect_id1=Integer.parseInt(stext_id.getText());
		String fname=stext_fname.getText();
		String lname=stext_lname.getText();
		String gen=stext_gen.getText();
		int age=Integer.parseInt(stext_age.getText());
		int mobile=Integer.parseInt(stext_mobile.getText());
		int case_id=Integer.parseInt(stext_caseid.getText());
		int crime_id=Integer.parseInt(stext_crimeid.getText());
		String query="insert into suspect values(?,?,?,?,?,?,?,?)";
		
		try {
			
			Connection con=DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1, suspect_id1);
		      preparedStmt.setString (2, fname);
		      preparedStmt.setString   (3, lname);
		      preparedStmt.setString(4, gen);
		      preparedStmt.setInt(5, age);
		      preparedStmt.setInt(6, mobile);
		      preparedStmt.setInt(7, case_id);
		      preparedStmt.setInt(8, crime_id);
		      preparedStmt.execute();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		suspect_reset(null);
	}
	public void search_suspect(MouseEvent e)
	{
		
		ObservableList<SuspectTable> oblist2 =FXCollections.observableArrayList();
			
			String fname=sstext_fname.getText();
			String lname=sstext_lname.getText();
			String query="select * from suspect where fname=? or lname=?";
			
			try {
				
				Connection con=DBConnector.getConnection();
				ResultSet rs=null;
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
			      preparedStmt.setString (1, fname);
			      preparedStmt.setString  (2, lname);
			     
			      rs=preparedStmt.executeQuery();
			      while(rs.next())
					{
						
						oblist2.add(new SuspectTable(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
					}
			}
			catch(Exception a)
			{
				a.printStackTrace();
			}
			
			
				
			
			sid1.setCellValueFactory(new PropertyValueFactory<>("sid"));
			fname1.setCellValueFactory(new PropertyValueFactory<>("fname"));
			lname1.setCellValueFactory(new PropertyValueFactory<>("lname"));
			gen1.setCellValueFactory(new PropertyValueFactory<>("gen"));
			age1.setCellValueFactory(new PropertyValueFactory<>("age"));
			mobile1.setCellValueFactory(new PropertyValueFactory<>("mobile"));
			case_id1.setCellValueFactory(new PropertyValueFactory<>("case_id"));
			crime_id1.setCellValueFactory(new PropertyValueFactory<>("crime_id"));
			
			suspect_table1.setItems(oblist2);
			
			sstext_fname.setText(null);
			sstext_lname.setText(null);
		
	}
	public void insert_criminal(MouseEvent e)
	{
		
		
		int criminal_id1=Integer.parseInt(crtext_id.getText());
		String fname=crtext_fname.getText();
		String lname=crtext_lname.getText();
		String gen=crtext_gen.getText();
		int age=Integer.parseInt(crtext_age.getText());
		int mobile=Integer.parseInt(crtext_mobile.getText());
		int case_id=Integer.parseInt(crtext_caseid.getText());
		String status=crtext_status.getValue();
		
		String date=crtext_date.getValue().toString();
		System.out.println(date);
		
		String query="insert into criminal values(?,?,?,?,?,?,?,?,?)";

		try {
			
			Connection con=DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1, criminal_id1);
		      preparedStmt.setString (2, fname);
		      preparedStmt.setString   (3, lname);
		      preparedStmt.setInt(4, mobile);
		      preparedStmt.setInt(5, age);
		      preparedStmt.setInt(6, case_id);
		      preparedStmt.setString(7, gen);
		      preparedStmt.setString(8,date);
		      preparedStmt.setString(9,status);
		      preparedStmt.execute();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		criminal_reset(null);
	}
	public void search_criminal(MouseEvent e)
	{
		ObservableList<CriminalTable> oblist =FXCollections.observableArrayList();
		int criminal_id1=Integer.parseInt(crstext_id.getText());

		
		String fname=crstext_fname.getText();
		int case_id=Integer.parseInt(crstext_caseid.getText());
		
		String query="select * from criminal where criminal_id=? or fname=? or case_id=?";
		
		
			try {
				
				Connection con=DBConnector.getConnection();
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt (1, criminal_id1);
			      preparedStmt.setString (2, fname);
			     preparedStmt.setInt(3, case_id);
			      preparedStmt.execute();
			ResultSet rs=null;
			rs=preparedStmt.executeQuery();
			while(rs.next())
			{
				
			
				oblist.add(new CriminalTable(rs.getInt("Criminal_ID"), rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		col_cid1.setCellValueFactory(new PropertyValueFactory<>("criminal_id"));
		col_fname1.setCellValueFactory(new PropertyValueFactory<>("fname"));
		col_lname1.setCellValueFactory(new PropertyValueFactory<>("lname"));
		col_gen1.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		col_age1.setCellValueFactory(new PropertyValueFactory<>("Age"));
		col_mob1.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		col_caseid1.setCellValueFactory(new PropertyValueFactory<>("case_id"));
		col_status1.setCellValueFactory(new PropertyValueFactory<>("status"));
		col_release1.setCellValueFactory(new PropertyValueFactory<>("release_date"));
		criminal_table1.setItems(oblist);
		
		crstext_caseid.setText(null);
		crstext_fname.setText(null);
		crstext_id.setText(null);
		
	}
	public void insert_case(MouseEvent e)
	{
		
		
		int case_id1=Integer.parseInt(ctext_id.getText());
		String area=ctext_area.getText();
		String desc=ctext_desc.getText();
		int act=Integer.parseInt(ctext_act.getText());
		int victim=Integer.parseInt(ctext_victim.getText());
		int suspect=Integer.parseInt(ctext_suspect.getText());
		String status=(String) ctext_status.getValue();
		
		String date=ctext_date.getValue().toString();
		
		
		String query="insert into fir values(?,?,?,?,?,?,?,?)";

		try {
			
			Connection con=DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1, victim);
		      preparedStmt.setString(2, desc);
		      preparedStmt.setInt(3, suspect);
		      preparedStmt.setInt(4, act);
		      preparedStmt.setString(5, status);
		      preparedStmt.setString(6,date);
			  preparedStmt.setInt (7, case_id1);
		      preparedStmt.setString(8, area);
			  
		      preparedStmt.execute();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		case_reset(null);
	}
	public void search_case(MouseEvent e)
	{
		ObservableList<CaseTable> oblist1 =FXCollections.observableArrayList();
		int case_id1=Integer.parseInt(cstext_id.getText());
		String area=cstext_area.getText();
		String date=cstext_date.getValue().toString();
		
		
		String query="select * from fir where case_id=? or area=? or date=?";

		try {
			
			Connection con=DBConnector.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			  preparedStmt.setInt (1, case_id1);
		      preparedStmt.setString(2, area);
			  preparedStmt.setString(3,date);
			  ResultSet rs=null;
		      rs=preparedStmt.executeQuery();
		      
		      while(rs.next())
				{
					
					oblist1.add(new CaseTable(rs.getInt(7), rs.getString(8),rs.getString(2),rs.getInt(4),
							rs.getInt(1),rs.getInt(3),rs.getDate(6),rs.getString(5)));
				}
			}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
		caseid1.setCellValueFactory(new PropertyValueFactory<>("case_id"));
			col_area1.setCellValueFactory(new PropertyValueFactory<>("area"));
			desc1.setCellValueFactory(new PropertyValueFactory<>("desc"));
			act1.setCellValueFactory(new PropertyValueFactory<>("act"));
			victim1.setCellValueFactory(new PropertyValueFactory<>("victim"));
			suspect1.setCellValueFactory(new PropertyValueFactory<>("suspect"));
			date1.setCellValueFactory(new PropertyValueFactory<>("date"));
			status1.setCellValueFactory(new PropertyValueFactory<>("status"));
			case_table1.setItems(oblist1);
			
			cstext_area.setText(null);
			cstext_id.setText(null);
			cstext_date.setValue(null);
	}
	public void victim_reset(ActionEvent e)
	{
		vtext_id.setText(null);
		vtext_fname.setText(null);
		vtext_lname.setText(null);
		vtext_gen.setText(null);
		vtext_age.setText(null);
		vtext_mobile.setText(null);
		vtext_caseid.setText(null);
	}
	public void criminal_reset(ActionEvent e)
	{
		crtext_id.setText(null);
		crtext_fname.setText(null);
		crtext_lname.setText(null);
		crtext_gen.setText(null);
		crtext_age.setText(null);
		crtext_mobile.setText(null);
		crtext_caseid.setText(null);
		crtext_date.setValue(null);
		crtext_status.setValue(null);
	}
	public void case_reset(ActionEvent e)
	{
		ctext_id.setText(null);
		ctext_area.setText(null);
		ctext_desc.setText(null);
		ctext_act.setText(null);
		ctext_victim.setText(null);
		ctext_suspect.setText(null);
		ctext_status.setValue(null);
		ctext_date.setValue(null);
		
	}
	public void suspect_reset(ActionEvent e)
	{
		stext_id.setText(null);
		stext_fname.setText(null);
		stext_lname.setText(null);
		stext_gen.setText(null);
		stext_age.setText(null);
		stext_mobile.setText(null);
		stext_caseid.setText(null);
		stext_crimeid.setText(null);
	}
	public void barChart()
	{
		XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
		series1.setName("Hadapsar"); 
		series1.getData().add(new XYChart.Data<>("Robbery", 1.0)); 
		series1.getData().add(new XYChart.Data<>("Murder", 3.0)); 
		series1.getData().add(new XYChart.Data<>("Cyber", 5.0)); 
		series1.getData().add(new XYChart.Data<>("Kidnapping", 5.0)); 
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
		series2.setName("Pune City"); 
		series2.getData().add(new XYChart.Data<>("Robbery", 5.0)); 
		series2.getData().add(new XYChart.Data<>("Murder", 6.0));  
		series2.getData().add(new XYChart.Data<>("Cyber", 10.0)); 
		series2.getData().add(new XYChart.Data<>("Kidnapping", 4.0));  

		XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
		series3.setName("M.Wadi"); 
		series3.getData().add(new XYChart.Data<>("Robbery", 4.0)); 
		series3.getData().add(new XYChart.Data<>("Murder", 2.0)); 
		series3.getData().add(new XYChart.Data<>("Cyber", 3.0)); 
		series3.getData().add(new XYChart.Data<>("Kidnapping", 6.0));
		
		bar.getData().addAll(series1, series2, series3);

	}
	public void progressBar()
	{
		Connection con=DBConnector.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		double total=0,val=0,val1=0;

		try {
			ps=con.prepareStatement("select count(status) from fir");
			rs=ps.executeQuery();
			while(rs.next())
				total=rs.getInt(1);
			total_cases.setProgress(total);
			total_label.setText(Double.toString(total));

			ps=con.prepareStatement("select count(status) from fir where status='Ongoing'");
			rs=ps.executeQuery();
			while(rs.next()) 
				val=rs.getInt(1);
			val=(val/total)*100;
			com_cases.setProgress(val);
			com_label.setText(Integer.toString((int) val));

			ps=con.prepareStatement("select count(status) from fir where status='Done'");
			rs=ps.executeQuery();
			while(rs.next()) 
				val1=rs.getInt(1);
			val1=(val1/total)*100;
			run_cases.setProgress(val1);
			run_label.setText(Integer.toString((int) val1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}