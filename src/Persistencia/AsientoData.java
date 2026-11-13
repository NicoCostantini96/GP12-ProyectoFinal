package Persistencia;

import Modelo.Asiento;
import Modelo.Pasajero;
import static Vista.VistaMain.viajeData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public class AsientoData {

    private final Connection con;

    public AsientoData() {
        this.con = Conexion.cargarConexion();
    }

    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";

    public void insert(Asiento obj) {
        try {
            String sql = "INSERT INTO lugares(id_ruta, numero_asiento, estado) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, obj.getRuta().getId_ruta());
            ps.setInt(2, obj.getNumero_asiento());
            ps.setBoolean(3, obj.getEstado());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    obj.setId_lugar(rs.getInt(1));
                }
                System.out.println(cGreen + "Asiento registrado con exito!!\n" + cReset);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Datos del Asiento incompatibles!!\n");
            System.out.println(e);
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
            String sql = "update lugares set id_ruta = ?, numero_asiento = ?, estado = ? where id_lugar = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getRuta().getId_ruta());
            ps.setInt(2, obj.getNumero_asiento());
            ps.setBoolean(3, obj.getEstado());
            ps.setInt(4, obj.getId_lugar());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Lugar editado con exito!!\n" + cReset);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Datos del lugar incompatibles!!\n");
            System.out.println(e);
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
                        viajeData.getById(res.getInt("id_ruta")),
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
                        viajeData.getById(res.getInt("id_ruta")),
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

    public ArrayList<Asiento> SQL(String sql) {
        ArrayList<Asiento> lista = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                lista.add(new Asiento(
                        res.getInt("id_lugar"),
                        viajeData.getById(res.getInt("id_ruta")),
                        res.getInt("numero_asiento"),
                        res.getBoolean("estado")
                ));
            }

        } catch (SQLException e) {
            System.err.println("ERROR SQL: " + e);
        }

        return lista;
    }
}
