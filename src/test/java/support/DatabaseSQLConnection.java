package support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import keys.devKey;

public class DatabaseSQLConnection  {
	public class canGetAllStates implements List<String> {

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<String> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(String e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends String> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends String> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

		@Override
		public String get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String set(int index, String element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int index, String element) {
			// TODO Auto-generated method stub

		}

		@Override
		public String remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<String> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<String> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private int PORT = new devKey().getMySQLPort();
	private String url = "jdbc:mysql://127.0.0.1:" + PORT +"/world";
	private String userId = new devKey().getMySQLUsername();
	private String password = new devKey().getMySQLPassword();
	private Connection connection = null;

	//Connection Test
	@Test
	private void canConnectToDatabase() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, userId, password);

			if (connection == null) {
				throw new RuntimeException((new Exception("Failed to make connection!")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(new Exception(String.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(connection != null ) {
				System.out.println("Connection Successful!");
				connection.close();
			}
		}
	}

	public ArrayList<String> canGetAllStates() throws SQLException {

		ArrayList<String> stateList = new ArrayList<String>();
		String sql = "SELECT * FROM world.tbl_state";

		try {
			connection = getDatabaseConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				stateList.add(resultSet.getString("state_name"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(connection != null ) {
				connection.close();
			}
		}
		return stateList;
	}

	private Connection getDatabaseConnection() throws Exception {
		connection = DriverManager.getConnection(url, userId, password);

		if (connection == null) {
			throw new Exception("Failed to make connection!");
		}	

		return connection;
	}
}
