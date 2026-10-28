package Persistencia;
import Modelo.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeroData {
    private final Connection con;
    
    public PasajeroData() {
        this.con = Conexion.cargarConexion();
    }
    
    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
     public void insert(Pasajero obj) {
        try {
            String sql = "insert into pasajeros(dni, nombre, apellidos, correo, telefono, estado) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getDni());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getCorreo());
            ps.setString(5, obj.getTelefono());
            ps.setBoolean(6, obj.getEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Pasajero registrado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del pasajero incompatibles!!\n");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from pasajeros where id_pasajero = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Se ha eliminado el pasajero correctamente!!\n"+cReset);
            }else
                System.err.println("ERROR: No se ha encontrado el pasajero!!\n");
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado el pasajero!!\n");
        }
    }
    
    public void update(Pasajero obj) {
        try {
            String sql = "update pasajeros set dni = ?, nombre = ?, apellidos = ?, correo = ?, telefono = ?, estado = ? where id_pasajero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getDni());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getCorreo());
            ps.setString(5, obj.getTelefono());
            ps.setBoolean(6, obj.getEstado());
            ps.setInt(7, obj.getId_pasajero());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Pasajero editado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del pasajero incompatibles!!\n");
            System.out.println(e);
        }
    }
    
    public Pasajero getById(int id) {
        Pasajero obj = null;
        try{
            String sql = "select * from pasajeros where id_pasajero = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                obj = new Pasajero(
                    res.getInt("id_pasajero"),
                    res.getString("dni"),
                    res.getString("nombre"),
                    res.getString("apellidos"),
                    res.getString("correo"),
                    res.getString("telefono"),
                    res.getBoolean("estado")
                );
            }
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado el pasajero!! "+e+"\n");
        }
        return obj;
    }
     
    public ArrayList<Pasajero> getList() {
        ArrayList<Pasajero> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pasajeros";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Pasajero obj = new Pasajero(
                    res.getInt("id_pasajero"),
                    res.getString("dni"),
                    res.getString("nombre"),
                    res.getString("apellidos"),
                    res.getString("correo"),
                    res.getString("telefono"),
                    res.getBoolean("estado")
                );
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
