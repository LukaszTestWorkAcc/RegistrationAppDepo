package sample.datamodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Datasource {

    public static final String DB_NAME = "Registration.db";

//  public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TABLE_DOCTOR = "Doctor";
    public static final String COLUMN_DOCTOR_ID = "_id";
    public static final String COLUMN_DOCTOR_NAME = "Name";
    public static final String COLUMN_DOCTOR_SURNAME = "Surname";
    public static final String COLUMN_DOCTOR_TELEPHONE = "Telephone";
    public static final String COLUMN_DOCTOR_ADDRESS = "Address";

    public static final int INDEX_DOCTOR_ID = 1;
    public static final int INDEX_DOCTOR_NAME = 2;
    public static final int INDEX_DOCTOR_SURNAME = 3;
    public static final int INDEX_DOCTOR_TELEPHONE = 4;
    public static final int INDEX_DOCTOR_ADDRESS = 5;


    public static final String TABLE_PATIENT = "Patient";
    public static final String COLUMN_PATIENT_ID = "_id";
    public static final String COLUMN_PATIENT_NAME = "Name";
    public static final String COLUMN_PATIENT_SURNAME = "Surname";
    public static final String COLUMN_PATIENT_TELEPHONE = "Telephone";
    public static final String COLUMN_PATIENT_ADDRESS = "Address";

    public static final int INDEX_PATIENT_ID = 1;
    public static final int INDEX_PATIENT_NAME = 2;
    public static final int INDEX_PATIENT_SURNAME = 3;
    public static final int INDEX_PATIENT_TELEPHONE = 4;
    public static final int INDEX_PATIENT_ADDRESS = 5;


    public static final String TABLE_ROOM = "Room";
    public static final String COLUMN_ROOM_ID = "_id";
    public static final String COLUMN_ROOM_NAME = "Room_name";

    public static final int INDEX_ROOM_ID = 1;
    public static final int INDEX_ROOM_NAME = 2;


    public static final String TABLE_VISIT = "Visit";
    public static final String COLUMN_VISIT_ID = "_id";
    public static final String COLUMN_VISIT_PATIENT_ID = "Patient_id";
    public static final String COLUMN_VISIT_VISITS_AVAILABILITY_ID = "Visits_availability_id";
    public static final String COLUMN_VISIT_STATUS = "Status";
    public static final String COLUMN_VISIT_NUMBER = "Number";

    public static final int INDEX_VISIT_ID = 1;
    public static final int INDEX_VISIT_PATIENT_ID = 2;
    public static final int INDEX_VISIT_VISITS_SAVAILABILITY_ID = 3;
    public static final int INDEX_VISIT_STATUS = 4;
    public static final int INDEX_VISIT_NUMBER = 5;


    public static final String TABLE_VISITS_AVAILABILITY = "Visits_availability";
    public static final String COLUMN_VISITS_AVAILABILITY_ID = "_id";
    public static final String COLUMN_VISITS_AVAILABILITY_DOCTOR_ID = "Doctor_id";
    public static final String COLUMN_VISITS_AVAILABILITY_ROOM_ID = "Room_id";
    public static final String COLUMN_VISITS_AVAILABILITY_FROM = "BHour";
    public static final String COLUMN_VISITS_AVAILABILITY_DATE = "DateOfV";
    public static final String COLUMN_VISITS_AVAILABILITY_LIMIT = "LimitOfAv";

    public static final int INDEX_VISITS_AVAILABILITY_ID = 1;
    public static final int INDEX_VISITS_AVAILABILITY_DOCTOR_ID = 2;
    public static final int INDEX_VISITS_AVAILABILITY_ROOM_ID = 3;
    public static final int INDEX_VISITS_AVAILABILITY_FROM = 4;
    public static final int INDEX_VISITS_AVAILABILITY_DATE = 5;
    public static final int INDEX_VISITS_AVAILABILITY_LIMIT = 6;

    public static final String TABLE_VIEW_VISITS_AVAILABILITY = "v_visitsAv";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_ID = "_id";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_DOCTOR_NAME = "Name";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_DOCTOR_SURNAME = "Surname";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_ROOM_NAME = "Room_name";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_FROM = "BHour";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_DATE = "DateOfV";
    public static final String COLUMN_VIEW_VISITS_AVAILABILITY_LIMIT = "LimitOfAv";

    public static final int INDEX_VIEW_VISITS_AVAILABILITY_ID = 1;
    public static final int INDEX_VIEW_VISITS_AVAILABILITY_DOCTOR_NAME = 2;
    public static final int INDEX_VIEW_VISITS_AVAILABILITY_DOCTOR_SURNAME = 3;
    public static final int INDEX_VIEW_VISITS_AVAILABILITY_ROOM_NAME = 4;
    public static final int INDEX_VIEW_VISITS_AVAILABILITY_FROM = 5;
    public static final int INDEX_VIEW_VISITS_AVAILABILITY_DATE = 6;
    public static final int INDEX_VIEW_VISITS_AVAILABILITY_LIMIT = 7;


    public static final String TABLE_VIEW_VISITS = "v_visits";
    public static final String COLUMN_VIEW_VISITS_ID = "_id";
    public static final String COLUMN_VIEW_VISITS_NAME = "Name";
    public static final String COLUMN_VIEW_VISITS_SURNAME = "Surname";
    public static final String COLUMN_VIEW_VISITS_STATUS = "Status";
    public static final String COLUMN_VIEW_VISITS_ROOM_NAME = "Room_name";
    public static final String COLUMN_VIEW_VISITS_FROM = "BHour";
    public static final String COLUMN_VIEW_VISITS_DATE = "DateOfV";

    public static final int INDEX_VIEW_VISITS_ID = 1;
    public static final int INDEX_VIEW_VISITS_NAME = 2;
    public static final int INDEX_VIEW_VISITS_SURNAME = 3;
    public static final int INDEX_VIEW_VISITS_STATUS = 4;
    public static final int INDEX_VIEW_VISITS_ROOM_NAME = 5;
    public static final int INDEX_VIEW_VISITS_FROM = 6;
    public static final int INDEX_VIEW_VISITS_DATE = 7;

    public static final String QUERY_ALL_DOCTORS = "SELECT * FROM " + TABLE_DOCTOR +
            " ORDER BY " + COLUMN_DOCTOR_SURNAME + " COLLATE NOCASE";

    public static final String QUERY_ALL_PATIENTS = "SELECT * FROM " + TABLE_PATIENT +
            " ORDER BY " + COLUMN_PATIENT_SURNAME + " COLLATE NOCASE";

    public static final String QUERY_ALL_ROOMS = "SELECT * FROM " + TABLE_ROOM +
            " ORDER BY " + COLUMN_ROOM_NAME + " COLLATE NOCASE";

    public static final String QUERY_ALL_VISITS = "SELECT * FROM " + TABLE_VISIT +
            " ORDER BY " + COLUMN_VISIT_ID + " DESC";

    public static final String QUERY_ALL_VISITS_AVAILABILITY = "SELECT * FROM " + TABLE_VISITS_AVAILABILITY +
            " ORDER BY " + COLUMN_VISITS_AVAILABILITY_ID + " DESC";

    public static final String QUERY_VIEW_VISITS_AVAILABILITY = "SELECT * FROM " + TABLE_VIEW_VISITS_AVAILABILITY +
            " ORDER BY " + COLUMN_VIEW_VISITS_AVAILABILITY_ID + " DESC";

    public static final String QUERY_ALL_VIEW_VISITS = "SELECT * FROM " + TABLE_VIEW_VISITS +
            " ORDER BY " + COLUMN_VIEW_VISITS_ID + " DESC";

    public static final String INSERT_PATIENT = "INSERT INTO " + TABLE_PATIENT +
            '(' + COLUMN_PATIENT_NAME + ", " + COLUMN_PATIENT_SURNAME + ", " + COLUMN_PATIENT_TELEPHONE + ", " + COLUMN_PATIENT_ADDRESS +
            ")VALUES(?, ?, ?, ?)";

    public static final String UPDATE_PATIENT = "UPDATE " + TABLE_PATIENT +
            " SET " + COLUMN_PATIENT_NAME + " =?, " + COLUMN_PATIENT_SURNAME + " =?, " + COLUMN_PATIENT_TELEPHONE + " =?, " + COLUMN_PATIENT_ADDRESS + " =? " +
            "WHERE " + COLUMN_PATIENT_ID + " =? ";

    public static final String UPDATE_VISIT = "UPDATE " + TABLE_VISIT +
            " SET " + COLUMN_VISIT_STATUS + " =? " +
            "WHERE " + COLUMN_VISIT_ID + " =? ";

    public static final String INSERT_DOCTOR = "INSERT INTO " + TABLE_DOCTOR +
            '(' + COLUMN_DOCTOR_NAME + ", " + COLUMN_DOCTOR_SURNAME + ", " + COLUMN_DOCTOR_TELEPHONE + ", " + COLUMN_DOCTOR_ADDRESS +
            ")VALUES(?, ?, ?, ?)";

    public static final String UPDATE_DOCTOR = "UPDATE " + TABLE_DOCTOR +
            " SET " + COLUMN_DOCTOR_NAME + " =?, " + COLUMN_DOCTOR_SURNAME + " =?, " + COLUMN_DOCTOR_TELEPHONE + " =?, " + COLUMN_DOCTOR_ADDRESS + " =? " +
            "WHERE " + COLUMN_DOCTOR_ID + " =? ";

    public static final String INSERT_VISIT_AVAILABILITY = "INSERT INTO " + TABLE_VISITS_AVAILABILITY +
            '(' + COLUMN_VISITS_AVAILABILITY_DOCTOR_ID + ", " + COLUMN_VISITS_AVAILABILITY_ROOM_ID + ", " + COLUMN_VISITS_AVAILABILITY_FROM + ", " +
            COLUMN_VISITS_AVAILABILITY_DATE + " ," + COLUMN_VISITS_AVAILABILITY_LIMIT + ") VALUES(?,?,?,?,?)";


    public static final String INSERT_VISIT = "INSERT INTO " + TABLE_VISIT +
            '(' + COLUMN_VISIT_PATIENT_ID + ", " + COLUMN_VISIT_VISITS_AVAILABILITY_ID + ", " + COLUMN_VISIT_STATUS + ", " + COLUMN_VISIT_NUMBER +
            ")VALUES(?, ?, ?, ?)";

    public static final String COUNT_REGISTERED_VISITS_ON_SELECTED_DATE = "SELECT COUNT(*) FROM " + TABLE_VISIT +
            " WHERE " + COLUMN_VISIT_VISITS_AVAILABILITY_ID + " =?";


    private Connection conn;

    //Prepared statements
    private PreparedStatement insertIntoPatients;
    private PreparedStatement updatePatients;
    private PreparedStatement insertIntoDoctors;
    private PreparedStatement updateDoctors;
    private PreparedStatement insertIntoVisitsAv;
    private PreparedStatement insertIntoVisits;
    private PreparedStatement countVisitsOnSDate;
    private PreparedStatement updateVisits;


    private static Datasource instance = new Datasource();

    private Datasource() {
    }

    ;

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);

            insertIntoPatients = conn.prepareStatement(INSERT_PATIENT);
            updatePatients = conn.prepareStatement(UPDATE_PATIENT);
            insertIntoDoctors = conn.prepareStatement(INSERT_DOCTOR);
            updateDoctors = conn.prepareStatement(UPDATE_DOCTOR);
            insertIntoVisitsAv = conn.prepareStatement(INSERT_VISIT_AVAILABILITY);
            insertIntoVisits = conn.prepareStatement(INSERT_VISIT);
            countVisitsOnSDate = conn.prepareStatement(COUNT_REGISTERED_VISITS_ON_SELECTED_DATE);
            updateVisits = conn.prepareStatement(UPDATE_VISIT);

            return true;
        } catch (SQLException e) {
            System.out.println("Cannot connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (insertIntoPatients != null) {
                insertIntoPatients.close();
            }
            if (updatePatients != null) {
                updatePatients.close();
            }
            if (insertIntoDoctors != null) {
                insertIntoDoctors.close();
            }
            if (updateDoctors != null) {
                updateDoctors.close();
            }
            if (insertIntoVisitsAv != null) {
                insertIntoVisitsAv.close();
            }
            if (insertIntoVisits != null) {
                insertIntoVisits.close();
            }
            if (countVisitsOnSDate != null) {
                countVisitsOnSDate.close();
            }
            if (updateVisits != null){
                updateVisits.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Cannot close connection" + e.getMessage());
        }
    }

    public List<Doctor> queryDoctors() {


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_ALL_DOCTORS)) {

            List<Doctor> doctors = new ArrayList<>();
            while (results.next()) {
//                try {
//                    Thread.sleep(20);
//                } catch(InterruptedException e) {
//                    System.out.println("Interuppted: " + e.getMessage());
//                }
                Doctor doctor = new Doctor();
                doctor.setId(results.getInt(INDEX_DOCTOR_ID));
                doctor.setName(results.getString(INDEX_DOCTOR_NAME));
                doctor.setSurname(results.getString(INDEX_DOCTOR_SURNAME));
                doctor.setTelephone(results.getString(INDEX_DOCTOR_TELEPHONE));
                doctor.setAddress(results.getString(INDEX_DOCTOR_ADDRESS));
                doctors.add(doctor);
            }

            return doctors;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Patient> queryPatients() {


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_ALL_PATIENTS)) {

            List<Patient> patients = new ArrayList<>();
            while (results.next()) {

                Patient patient = new Patient();
                patient.setId(results.getInt(INDEX_PATIENT_ID));
                patient.setName(results.getString(INDEX_PATIENT_NAME));
                patient.setSurname(results.getString(INDEX_PATIENT_SURNAME));
                patient.setTelephone(results.getString(INDEX_PATIENT_TELEPHONE));
                patient.setAddress(results.getString(INDEX_PATIENT_ADDRESS));
                patients.add(patient);
            }

            return patients;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Room> queryRooms() {


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_ALL_ROOMS)) {

            List<Room> rooms = new ArrayList<>();
            while (results.next()) {

                Room room = new Room();
                room.setId(results.getInt(INDEX_ROOM_ID));
                room.setRoom_name(results.getString(INDEX_ROOM_NAME));
                rooms.add(room);
            }

            return rooms;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<V_VisitAv> queryV_VisitAv() {


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_VIEW_VISITS_AVAILABILITY)) {

            List<V_VisitAv> v_VisitAvList = new ArrayList<>();
            while (results.next()) {

                V_VisitAv v_visitAv = new V_VisitAv();
                v_visitAv.setId(results.getInt(INDEX_VIEW_VISITS_AVAILABILITY_ID));
                v_visitAv.setDoctor_name(results.getString(INDEX_VIEW_VISITS_AVAILABILITY_DOCTOR_NAME));
                v_visitAv.setDoctor_surname(results.getString(INDEX_VIEW_VISITS_AVAILABILITY_DOCTOR_SURNAME));
                v_visitAv.setRoom_name(results.getString(INDEX_VIEW_VISITS_AVAILABILITY_ROOM_NAME));
                v_visitAv.setFrom(results.getString(INDEX_VIEW_VISITS_AVAILABILITY_FROM));
                v_visitAv.setDate(results.getString(INDEX_VIEW_VISITS_AVAILABILITY_DATE));
                v_visitAv.setLimit(results.getInt(INDEX_VIEW_VISITS_AVAILABILITY_LIMIT));
                v_VisitAvList.add(v_visitAv);
            }

            return v_VisitAvList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<V_Visit> queryV_Visit() {


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_ALL_VIEW_VISITS)) {

            List<V_Visit> v_VisitList = new ArrayList<>();
            while (results.next()) {

                V_Visit v_visit = new V_Visit();
                v_visit.setId(results.getInt(INDEX_VIEW_VISITS_ID));
                v_visit.setName(results.getString(INDEX_VIEW_VISITS_NAME));
                v_visit.setSurname(results.getString(INDEX_VIEW_VISITS_SURNAME));
                v_visit.setStatus(results.getString(INDEX_VIEW_VISITS_STATUS));
                v_visit.setRoom_name(results.getString(INDEX_VIEW_VISITS_ROOM_NAME));
                v_visit.setFrom(results.getString(INDEX_VIEW_VISITS_FROM));
                v_visit.setDate(results.getString(INDEX_VIEW_VISITS_DATE));

                v_VisitList.add(v_visit);
            }

            return v_VisitList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public void insertPatient(String name, String surname, String telephone, String address) {
        try {
            insertIntoPatients.setString(1, name);
            insertIntoPatients.setString(2, surname);
            insertIntoPatients.setString(3, telephone);
            insertIntoPatients.setString(4, address);

            int affectedRows = insertIntoPatients.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The patient insert failed");
            }
        } catch (Exception e) {
            System.out.println("Insert patient exception " + e.getMessage());
        }
    }

    public void updatePatient(int id, String name, String surname, String telephone, String address) {
        try {
            updatePatients.setString(1, name);
            updatePatients.setString(2, surname);
            updatePatients.setString(3, telephone);
            updatePatients.setString(4, address);
            updatePatients.setInt(5, id);

            int affectedRows = updatePatients.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The patient update failed");
            }

        } catch (Exception e) {
            System.out.println("Insert patient exception " + e.getMessage());
        }
    }

    public void updateVisit(int id, String status) {
        try {
            updateVisits.setString(1, status);
            updateVisits.setInt(2, id);

            int affectedRows = updateVisits.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The visit update failed");
            }

        } catch (Exception e) {
            System.out.println("Insert patient exception " + e.getMessage());
        }
    }

    public void insertDoctor(String name, String surname, String telephone, String address) {
        try {
            insertIntoDoctors.setString(1, name);
            insertIntoDoctors.setString(2, surname);
            insertIntoDoctors.setString(3, telephone);
            insertIntoDoctors.setString(4, address);

            int affectedRows = insertIntoDoctors.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The doctor insert failed");
            }
        } catch (Exception e) {
            System.out.println("Insert doctor exception " + e.getMessage());
        }
    }

    public void insertVisitAv(int doctor_id, int room_id, String BHour, String DateOfV, int LimitOfAv) {
        try {
            insertIntoVisitsAv.setInt(1, doctor_id);
            insertIntoVisitsAv.setInt(2, room_id);
            insertIntoVisitsAv.setString(3, BHour);
            insertIntoVisitsAv.setString(4, DateOfV);
            insertIntoVisitsAv.setInt(5, LimitOfAv);

            int affectedRows = insertIntoVisitsAv.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The VisitAvailability insert failed");
            }
        } catch (Exception e) {
            System.out.println("Insert VisitAvailability exception " + e.getMessage());
        }
    }

    public void updateDoctor(int id, String name, String surname, String telephone, String address) {
        try {
            updateDoctors.setString(1, name);
            updateDoctors.setString(2, surname);
            updateDoctors.setString(3, telephone);
            updateDoctors.setString(4, address);
            updateDoctors.setInt(5, id);

            int affectedRows = updateDoctors.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The doctor update failed");
            }

        } catch (Exception e) {
            System.out.println("Insert doctor exception " + e.getMessage());
        }
    }

    public void insertVisit(int patient_id, int visitAv_id, String status, int vNumber) {
        try {
            insertIntoVisits.setInt(1, patient_id);
            insertIntoVisits.setInt(2, visitAv_id);
            insertIntoVisits.setString(3, status);
            insertIntoVisits.setInt(4, vNumber);

            int affectedRows = insertIntoVisits.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("The Visit insert failed");
            }
        } catch (Exception e) {
            System.out.println("Insert visit exception " + e.getMessage());
        }
    }

    public int getCountOfRegisteredVisitsOnDate(int tableAv_id) {

        try {
            countVisitsOnSDate.setInt(1, tableAv_id);

            ResultSet results = countVisitsOnSDate.executeQuery();
            int count = results.getInt(1);

            return count;
        } catch (Exception e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }

}
