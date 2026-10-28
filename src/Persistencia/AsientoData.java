package Persistencia;

import Modelo.Asiento;
import Modelo.Pasajero;
import static Vista.TestMain.colectivoData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsientoData {

    private final Connection con;

    public AsientoData() {
        this.con = Conexion.cargarConexion();
    }

    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";

    public void insert(Asiento obj) {
        try {
            String sql = "insert into lugares(id_lugar,id_colectivo,numero_asiento,estado) values (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId_lugar());
            ps.setInt(2, obj.getId_colectivo().getId_colectivo());
            ps.setInt(3, obj.getNumero_asiento());
            ps.setBoolean(4, obj.getEstado());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Asiento registrado con exito!!\n" + cReset);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Datos del Asiento incompatibles!!\n");
        }
    }

    public void remove(int id) {
        try {
            String sql = "delete from lugares where id_lugar = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Se ha eliminado el lugar correctamente!!\n" + cReset);
            } else {
                System.err.println("ERROR: No se ha encontrado el lugar!!\n");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: No se ha encontrado el lugar!!\n");
        }
    }

    public void update(Asiento obj) {
        try {
            String sql = "update lugares set id_colectivo = ?, numero_asiento = ?, estado = ? where id_lugar = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId_colectivo().getId_colectivo());
            ps.setInt(2, obj.getNumero_asiento());
            ps.setBoolean(3, obj.getEstado());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Pasajero editado con exito!!\n" + cReset);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Datos del pasajero incompatibles!!\n");
        }
    }

    public Asiento getById(int id) {
        Asiento obj = null;
        try {
            String sql = "select * from lugares where id_lugar = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet res = ps.executeQuery();
            while (res.next()) {
                obj = new Asiento(
                        res.getInt("id_lugar"),
                        colectivoData.getById(res.getInt("id_colectivo")),
                        res.getInt("numero_asiento"),
                        res.getBoolean("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("ERROR: No se ha encontrado el Asiento!! " + e + "\n");
        }
        return obj;
    }

    public ArrayList<Asiento> getList() {
        ArrayList<Asiento> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lugares";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Asiento obj = new Asiento(
                        res.getInt("id_lugar"),
                        colectivoData.getById(res.getInt("id_colectivo")),
                        res.getInt("numero_asiento"),
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
