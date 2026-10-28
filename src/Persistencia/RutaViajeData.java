package Persistencia;

import Modelo.Colectivo;
import Modelo.RutaViaje;
import static Vista.TestMain.colectivoData;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutaViajeData {

    private final Connection con;

    public RutaViajeData() {
        this.con = Conexion.cargarConexion();
    }

    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";

    public void insert(RutaViaje obj) {
        try {
            String sql = "insert into rutas(origen, destino, hora_salida, hora_llegada, id_colectivo, precio, estado) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getOrigen());
            ps.setString(2, obj.getDestino());
            ps.setTime(3, java.sql.Time.valueOf(obj.getHora_salida()));
            ps.setTime(4, java.sql.Time.valueOf(obj.getHora_llegada()));
            ps.setInt(5, obj.getColectivo().getId_colectivo());
            ps.setBigDecimal(6, BigDecimal.valueOf(obj.getPrecio()));
            ps.setBoolean(7, obj.getEstado());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Se registró la ruta con éxito.\n" + cReset);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Los datos de la ruta son incompatibles.\n");
        }
    }

    public void remove(int id) {
        try {
            String sql = "delete from rutas where id_ruta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Se eliminó la ruta exitosamente.\n" + cReset);
            } else {
                System.err.println("ERROR: No se ha encontrado la ruta indicada.\n");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: No se ha encontrado la ruta indicada.\n");
        }
    }

    public void update(RutaViaje obj) {
        try {
            String sql = "update rutas set origen = ?, destino = ?, hora_salida = ?, hora_llegada = ?, id_colectivo = ?, precio = ?, estado = ? where id_rutas = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getOrigen());
            ps.setString(2, obj.getDestino());
            ps.setTime(3, java.sql.Time.valueOf(obj.getHora_salida()));
            ps.setTime(4, java.sql.Time.valueOf(obj.getHora_llegada()));
            ps.setInt(5, obj.getColectivo().getId_colectivo());
            ps.setBigDecimal(6, BigDecimal.valueOf(obj.getPrecio()));
            ps.setBoolean(7, obj.getEstado());
            ps.setInt(8, obj.getId_ruta());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(cGreen + "Se ha editado la ruta con éxito.\n" + cReset);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Los datos de la ruta son incompatibles.\n");
        }
    }

    public RutaViaje getById(int id) {
        RutaViaje obj = null;
        try {
            String sql = "select * from rutas where id_ruta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet res = ps.executeQuery();
            while (res.next()) {
                obj = new RutaViaje(
                        res.getInt("id_ruta"),
                        res.getString("origen"),
                        res.getString("destino"),
                        res.getTime("hora_salida").toLocalTime(),
                        res.getTime("hora_llegada").toLocalTime(),
                        colectivoData.getById(id),
                        res.getBigDecimal("precio").doubleValue(),
                        res.getBoolean("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("ERROR: No se ha encontrado la ruta solicitada. " + e + "\n");
        }
        return obj;
    }

    public ArrayList<RutaViaje> getList() {
        ArrayList<RutaViaje> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rutas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Colectivo bondi = colectivoData.getById(res.getInt("id_colectivo"));

                RutaViaje obj = new RutaViaje(
                        res.getInt("id_ruta"),
                        res.getString("origen"),
                        res.getString("destino"),
                        res.getTime("hora_salida").toLocalTime(),
                        res.getTime("hora_llegada").toLocalTime(),
                        bondi,
                        res.getBigDecimal("precio").doubleValue(),
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
