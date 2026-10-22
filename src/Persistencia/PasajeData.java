package Persistencia;
import Modelo.Pasaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.pasajeroData;
import static Vista.TestMain.rutaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeData {
    private final Connection con;
    
    public PasajeData() {
        this.con = Conexion.cargarConexion();
    }
    
    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
     public void insert(Pasaje obj) {
        try {
            String sql = "insert into pasajes(id_pasajero, id_lugar, id_ruta, fecha_venta, hora_venta, precio, estado) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId_pasajero().getId_pasajero());
            ps.setInt(2, obj.getId_lugar().getId_lugar());
            ps.setInt(3, obj.getId_ruta().getId_ruta());
            ps.setDate(4, java.sql.Date.valueOf(obj.getFecha_venta()));
            ps.setTime(5, java.sql.Time.valueOf(obj.getHora_venta()));
            ps.setDouble(6, obj.getPrecio());
            ps.setBoolean(7, obj.getEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Pasaje registrado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del pasaje incompatibles!!\n");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from pasajes where id_pasaje = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Se ha eliminado el pasaje correctamente!!\n"+cReset);
            }else
                System.err.println("ERROR: No se ha encontrado el pasaje!!\n");
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado el pasaje!!\n");
        }
    }
    
    public void update(Pasaje obj) {
        try {
            String sql = "update pasajes set id_pasajero = ?, id_lugar = ?, id_ruta = ?, fecha_venta = ?, hora_venta = ?, precio = ?, estado = ? where id_pasaje = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId_pasajero().getId_pasajero());
            ps.setInt(2, obj.getId_lugar().getId_lugar());
            ps.setInt(3, obj.getId_ruta().getId_ruta());
            ps.setDate(4, java.sql.Date.valueOf(obj.getFecha_venta()));
            ps.setTime(5, java.sql.Time.valueOf(obj.getHora_venta()));
            ps.setDouble(6, obj.getPrecio());
            ps.setBoolean(7, obj.getEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Pasaje editado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del pasaje incompatibles!!\n");
        }
    }
    
    public Pasaje getById(int id) {
        Pasaje obj = null;
        try{
            String sql = "select * from pasajes where id_pasaje = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                obj = new Pasaje(
                    res.getInt("id_pasaje"),
                    pasajeroData.getById(res.getInt("id_pasajero")),
                    asientoData.getById(res.getInt("id_lugar")),
                    rutaData.getById(res.getInt("id_ruta")),
                    res.getDate("fecha_venta").toLocalDate(),
                    res.getTime("hora_venta").toLocalTime(),
                    res.getDouble("precio"),
                    res.getBoolean("estado")
                );
            }
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado el pasaje!! "+e+"\n");
        }
        return obj;
    }
     
    public ArrayList<Pasaje> getList() {
        ArrayList<Pasaje> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pasajes";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Pasaje obj = new Pasaje(
                    res.getInt("id_pasaje"),
                    pasajeroData.getById(res.getInt("id_pasajero")),
                    asientoData.getById(res.getInt("id_lugar")),
                    rutaData.getById(res.getInt("id_ruta")),
                    res.getDate("fecha_venta").toLocalDate(),
                    res.getTime("hora_venta").toLocalTime(),
                    res.getDouble("precio"),
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
