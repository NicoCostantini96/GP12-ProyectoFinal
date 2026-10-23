
package Persistencia;

import Modelo.Colectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ColectivoData {
    private final Connection con;
    
    public ColectivoData() {
        this.con = Conexion.cargarConexion();
    }
    
    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
    public void insert(Colectivo obj) {
        try {
            String sql = "insert into colectivos(matricula, marca, modelo, capacidad, chofer, estado) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getMatricula());
            ps.setString(2, obj.getMarca());
            ps.setString(3, obj.getModelo());
            ps.setInt(4, obj.getCapacidad());
            ps.setString(5, obj.getChofer());
            ps.setBoolean(6, obj.getEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Colectivo registrado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del colectivo incompatibles!!\n");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from colectivos where id_colectivo = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Se ha eliminado el colectivo correctamente!!\n"+cReset);
            }else
                System.err.println("ERROR: No se ha encontrado el colectivo!!\n");
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado el colectivo!!\n");
        }
    }
    
    public void update(Colectivo obj) {
        try {
            String sql = "update colectivos set matricula = ?, marca = ?, modelo = ?, capacidad = ?, chofer = ?, estado = ? where id_colectivo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getMatricula());
            ps.setString(2, obj.getMarca());
            ps.setString(3, obj.getModelo());
            ps.setInt(4, obj.getCapacidad());
            ps.setString(5, obj.getChofer());
            ps.setBoolean(6, obj.getEstado());
            ps.setInt(7, obj.getId_colectivo());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Colectivo editado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del colectivo incompatibles!!\n");
        }
    }
    
    public Colectivo getById(int id) {
        Colectivo obj = null;
        try{
            String sql = "select * from colectivos where id_colectivo = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                obj = new Colectivo(
                    res.getInt("id_colectivo"),
                    res.getString("matricula"),
                    res.getString("marca"),
                    res.getString("modelo"),
                    res.getInt("capacidad"),
                    res.getString("chofer"),
                    res.getBoolean("estado")
                );
            }
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado el colectivo!! "+e+"\n");
        }
        return obj;
    }
     
    public ArrayList<Colectivo> getList() {
        ArrayList<Colectivo> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM colectivos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Colectivo obj = new Colectivo(
                    res.getInt("id_colectivo"),
                    res.getString("matricula"),
                    res.getString("marca"),
                    res.getString("modelo"),
                    res.getInt("capacidad"),
                    res.getString("chofer"),
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

