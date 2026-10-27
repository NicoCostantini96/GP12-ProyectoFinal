package Vista;

import Modelo.Asiento;
import Modelo.Colectivo;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import Persistencia.AsientoData;
import Persistencia.ColectivoData;
import Persistencia.PasajeData;
import Persistencia.PasajeroData;
import Persistencia.RutaViajeData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class TestMain {

    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerLine = new Scanner(System.in);

    public static PasajeroData pasajeroData = new PasajeroData();
    public static ColectivoData colectivoData = new ColectivoData();
    public static AsientoData asientoData = new AsientoData();
    public static RutaViajeData rutaData = new RutaViajeData();
    public static PasajeData pasajeData = new PasajeData();

    public static void main(String[] args) {
        boolean finishProgram = false;
        while (!finishProgram) {
            boolean finishOptions = false;
            int optionSelected = 0;

            try {
                System.out.println("QUE DESEA TESTEAR:\n1 - Pasajero\n2 - Colectivo\n3 - Asiento\n4 - RutaViaje\n5 - Salir");
                System.out.print("\nIngrese el numero de su opcion: ");
                optionSelected = scannerInt.nextInt();
            } catch (Exception e) {
                scannerInt.nextLine();
                System.err.println("ERROR: Ingrese un valor valido!!\n");
            }

            while (optionSelected == 1) {
                listPasajero();
                System.out.println(
                        "OPCIONES:\n"
                        + "1 - Agregar un Pasajero\n"
                        + "2 - Eliminar un Pasajero\n"
                        + "3 - Editar un Pasajero\n"
                        + "4 - Salir"
                );
                finishOptions = false;
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch (optionResult) {
                            case 1: {
                                Pasajero obj = createPasajero(null);
                                if (obj != null) {
                                    pasajeroData.insert(obj);
                                }
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                Pasajero select = findPasajero();
                                if (select != null) {
                                    pasajeroData.remove(select.getId_pasajero());
                                }
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                Pasajero select = findPasajero();
                                if (select != null) {
                                    Pasajero updatedObj = createPasajero(select);
                                    if (updatedObj != null) {
                                        pasajeroData.update(updatedObj);
                                    }
                                }
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                optionSelected = 0;
                                break;
                            }
                            default: {
                                System.err.println("ERROR: Ingrese un valor disponible!!");
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR: Ingrese un valor valido!!");
                        scannerInt.nextLine();
                    }
                }
            }

            while (optionSelected == 2) {
                listColectivo();
                System.out.println(
                        "OPCIONES:\n"
                        + "1 - Agregar un Colectivo\n"
                        + "2 - Eliminar un Colectivo\n"
                        + "3 - Editar un Colectivo\n"
                        + "4 - Salir"
                );
                finishOptions = false;
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch (optionResult) {
                            case 1: {
                                Colectivo obj = createColectivo(null);
                                if (obj != null) {
                                    colectivoData.insert(obj);
                                }
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                Colectivo select = findColectivo();
                                if (select != null) {
                                    colectivoData.remove(select.getId_colectivo());
                                }
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                Colectivo select = findColectivo();
                                if (select != null) {
                                    Colectivo updatedObj = createColectivo(select);
                                    if (updatedObj != null) {
                                        colectivoData.update(updatedObj);
                                    }
                                }
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                optionSelected = 0;
                                break;
                            }
                            default: {
                                System.err.println("ERROR: Ingrese un valor disponible!!");
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR: Ingrese un valor valido!!");
                        scannerInt.nextLine();
                    }
                }
            }
            
            while (optionSelected == 3) {
                listAsiento();
                System.out.println(
                        "OPCIONES:\n"
                        + "1 - Agregar un Asiento\n"
                        + "2 - Eliminar un Asiento\n"
                        + "3 - Editar un Asiento\n"
                        + "4 - Salir"
                );
                finishOptions = false;
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch (optionResult) {
                            case 1: {
                                Asiento obj = createAsiento(null);
                                if (obj != null) {
                                    asientoData.insert(obj);
                                }
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                Asiento select = findAsiento();
                                if (select != null) {
                                    asientoData.remove(select.getId_lugar());
                                }
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                Asiento select = findAsiento();
                                if (select != null) {
                                    Asiento updatedObj = createAsiento(select);
                                    if (updatedObj != null) {
                                        asientoData.update(updatedObj);
                                    }
                                }
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                optionSelected = 0;
                                break;
                            }
                            default: {
                                System.err.println("ERROR: Ingrese un valor disponible!!");
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR: Ingrese un valor valido!!");
                        scannerInt.nextLine();
                    }
                }
            }

            while (optionSelected == 4) {
                listRuta();
                System.out.println(
                        "OPCIONES:\n"
                        + "1 - Agregar una Ruta\n"
                        + "2 - Eliminar una Ruta\n"
                        + "3 - Editar una Ruta\n"
                        + "4 - Salir"
                );
                finishOptions = false;
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch (optionResult) {
                            case 1: {
                                RutaViaje obj = createRuta(null);
                                if (obj != null) {
                                    rutaData.insert(obj);
                                }
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                RutaViaje select = findRuta();
                                if (select != null) {
                                    rutaData.remove(select.getId_ruta());
                                }
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                RutaViaje select = findRuta();
                                if (select != null) {
                                    RutaViaje updatedObj = createRuta(select);
                                    if (updatedObj != null) {
                                        rutaData.update(updatedObj);
                                    }
                                }
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                optionSelected = 0;
                                break;
                            }
                            default: {
                                System.err.println("ERROR: Ingrese un valor disponible!!");
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR: Ingrese un valor valido!!");
                        scannerInt.nextLine();
                    }
                }
            }
            
            if (optionSelected == 5) {
                break;
            }

            if ((optionSelected > 5 || optionSelected < 1) && !finishOptions) {
                System.err.println("ERROR: Ingrese un valor disponible!!\n");
            }

        }
    }
    
    // MÉTODOS DEL PASAJERO
    static public void listPasajero() {
        System.out.println("Lista de Pasajeros:");
        ArrayList<Pasajero> list = pasajeroData.getList();
        String formatList = "%-3s %-11s %-3s %-3s %-3s %-3s %s%n";
        System.out.printf(formatList, "ID:", "| DNI:", "| NOMBRE:", "| APELLIDO:", "| CORREO:", "| TELEFONO:", "| ESTADO:");
        for (Pasajero i : list) {
            System.out.printf(formatList, i.getId_pasajero(), "| " + i.getDni(), "| " + i.getNombre(), "| " + i.getApellido(), "| " + i.getCorreo(), "| " + i.getTelefono(), "| " + i.getEstado());
        }
        System.out.println("");
    }

    static public Pasajero findPasajero() {
        System.out.println("");
        listPasajero();
        Pasajero find = null;
        while (true) {
            try {
                System.out.print("Ingrese 0 para volver!!\nIngrese la ID del pasajero que desea tomar: ");
                int id = scannerInt.nextInt();
                if (id == 0) {
                    System.out.println("Regresando al menu anterior\n");
                    scannerInt.nextLine();
                    break;
                }
                find = pasajeroData.getById(id);
                if (find != null) {
                    break;
                } else {
                    System.err.println("ERROR: No se encontro el pasajero!!");
                }
            } catch (Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }
    
    static public Pasajero createPasajero(Pasajero obj) {
        int id = 0;
        int dni = 0;
        String nombre = "";
        String apellido = "";
        String correo = "";
        int telefono = 0;
        boolean estado = false;

        if (obj != null) {
            id = obj.getId_pasajero();
            dni = obj.getDni();
            nombre = obj.getNombre();
            apellido = obj.getApellido();
            correo = obj.getCorreo();
            telefono = obj.getTelefono();
            estado = obj.getEstado();
        }

        if (verifyChange(obj, "Desea modificar el dni? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el DNI del pasajero: ");
                    dni = scannerInt.nextInt();
                    if (String.valueOf(dni).length() == 8) {
                        break;
                    } else {
                        System.err.println("ERROR: Ingrese exactamente 8 numeros!!");
                        scannerInt.nextLine();
                    }
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un valor valido!!");
                    scannerInt.nextLine();
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el nombre? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el nombre del pasajero: ");
                nombre = scannerLine.nextLine();
                if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.err.println("ERROR: El nombre solo puede contener letras!!");
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el apellido? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el apellido del pasajero: ");
                apellido = scannerLine.nextLine();
                if (apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.err.println("ERROR: El apellido solo puede contener letras!!");
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el correo? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el correo del pasajero: ");
                correo = scannerLine.nextLine();
                break;
            }
        }

        if (verifyChange(obj, "Desea modificar el telefono? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el telefono del pasajero: ");
                    telefono = scannerInt.nextInt();
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Solo se permiten numeros!!");
                    scannerInt.nextLine();
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el estado? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese si el pasajero esta activo (s/n): ");
                String sactive = scannerLine.nextLine();
                if (sactive.toLowerCase().contains("s")) {
                    estado = true;
                    break;
                } else {
                    if (sactive.toLowerCase().contains("n")) {
                        break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }

        return new Pasajero(id, dni, nombre, apellido, correo, telefono, estado);
    }
    
    // MÉTODOS DEL COLECTIVO
    static public void listColectivo() {
        System.out.println("Lista de colectivos:");
        ArrayList<Colectivo> list = colectivoData.getList();
        String formatList = "%-3s %-11s %-3s %-3s %-3s %-3s %s%n";
        System.out.printf(formatList, "ID:", "| MATRICULA:", "| MARCA:", "| MODELO:", "| CAPACIDAD:", "| CHOFER:", "| ESTADO:");
        for (Colectivo i : list) {
            System.out.printf(formatList, i.getId_colectivo(), "| " + i.getMatricula(), "| " + i.getMarca(), "| " + i.getModelo(), "| " + i.getCapacidad(), "| " + i.getChofer(), "| " + i.getEstado());
        }
        System.out.println("");
    }

    static public Colectivo findColectivo() {
        System.out.println("");
        listColectivo();
        Colectivo find = null;
        while (true) {
            try {
                System.out.print("Ingrese 0 para volver!!\nIngrese la ID del colectivo que desea tomar: ");
                int id = scannerInt.nextInt();
                if (id == 0) {
                    System.out.println("Regresando al menu anterior\n");
                    scannerInt.nextLine();
                    break;
                }
                find = colectivoData.getById(id);
                if (find != null) {
                    break;
                } else {
                    System.err.println("ERROR: No se encontro el colectivo!!");
                }
            } catch (Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }

    static public Colectivo createColectivo(Colectivo obj) {
        int id = 0;
        String matricula = "";
        String marca = "";
        String modelo = "";
        int capacidad = 0;
        String chofer = "";
        boolean estado = false;

        if (obj != null) {
            id = obj.getId_colectivo();
            matricula = obj.getMatricula();
            marca = obj.getMarca();
            modelo = obj.getModelo();
            capacidad = obj.getCapacidad();
            chofer = obj.getChofer();
            estado = obj.getEstado();
        }

        if (verifyChange(obj, "Desea modificar la matricula? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese la matricula del colectivo: ");
                matricula = scannerLine.nextLine();

                if (matricula.length() <= 7 && matricula.length() >= 6) {
                    break;
                } else {
                    System.err.println("ERROR: La matricula debe tener entre 6 a 7 caracteres!");
                }

                if (matricula.matches("^[a-zA-Z0-9]+$")) {
                    break;
                } else {
                    System.err.println("ERROR: La matricula no puede contener caracteres especiales!");
                }
            }
        }

        if (verifyChange(obj, "Desea modificar la marca? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el nombre de la marca: ");
                marca = scannerLine.nextLine();
                if (marca.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.err.println("ERROR: El nombre solo puede contener letras!!");
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el modelo? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el nombre del modelo: ");
                modelo = scannerLine.nextLine();
                if (modelo.matches("^[a-zA-Z0-9]+$")) {
                    break;
                } else {
                    System.err.println("ERROR: El modelo no puede tener caracteres especiales!!");
                }
            }
        }

        if (verifyChange(obj, "Desea modificar la capacidad? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese la capacidad del colectivo: ");
                    capacidad = scannerInt.nextInt();

                    if (capacidad <= 33 && capacidad >= 12) {
                        break;
                    } else {
                        System.err.println("ERROR: La capacidad debe ser de 12 a 33!!");
                    }
                } catch (Exception e) {
                    System.err.println("ERROR: Solo se permiten numeros!!");
                    scannerInt.nextLine();
                }

            }
        }

        if (verifyChange(obj, "Desea modificar el chofer? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el nombre del chofer: ");
                chofer = scannerLine.nextLine();
                if (chofer.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.err.println("ERROR: El nombre solo puede contener letras!!");
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el estado? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese si el colectivo esta activo (s/n): ");
                String sactive = scannerLine.nextLine();
                if (sactive.toLowerCase().contains("s")) {
                    estado = true;
                    break;
                } else {
                    if (sactive.toLowerCase().contains("n")) {
                        break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }

        return new Colectivo(id, matricula, marca, modelo, capacidad, chofer, estado);
    }
    
    // MÉTODOS DEL ASIENTO
    static public void listAsiento() {
        System.out.println("Lista de asientos:");
        ArrayList<Asiento> list = asientoData.getList();
        String formatList = "%-3s %-11s %-3s %s%n";
        System.out.printf(formatList, "ID LUGAR:", "| ID COLECTIVO:", "| NUMERO ASIENTO:", "| ESTADO:");
        for (Asiento i : list) {
            System.out.printf(formatList, i.getId_lugar(), "| " + i.getId_colectivo().getId_colectivo(), "| " + i.getNumero_asiento(), "| " + i.getEstado());
        }
        System.out.println("");
    }

    static public Asiento findAsiento() {
        System.out.println("");
        listColectivo();
        Asiento find = null;
        while (true) {
            try {
                System.out.print("Ingrese 0 para volver!!\nIngrese la ID del asiento que desea tomar: ");
                int id = scannerInt.nextInt();
                if (id == 0) {
                    System.out.println("Regresando al menu anterior\n");
                    scannerInt.nextLine();
                    break;
                }
                find = asientoData.getById(id);
                if (find != null) {
                    break;
                } else {
                    System.err.println("ERROR: No se encontro el asiento!!");
                }
            } catch (Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }

    static public Asiento createAsiento(Asiento obj) {
        int id = 0;
        Colectivo colectivo = null;
        int num = 0;
        boolean estado = false;

        if (obj != null) {
            id = obj.getId_lugar();
            colectivo = obj.getId_colectivo();
            num = obj.getNumero_asiento();
            estado = obj.getEstado();
        }

        if (verifyChange(obj, "Desea modificar el colectivo? (s/n): ")) {
            colectivo = findColectivo();
        }

        if (verifyChange(obj, "Desea modificar el numero de asiento? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el numero de asiento: ");
                    num = scannerInt.nextInt();
                    if (num > 0 && num < 33) {
                        break;
                    } else {
                        String errText = "ERROR: Ingrese un valor menor que 34!!";
                        if (num < 1) {errText = "ERROR: Ingrese un valor mayor que 0!!";}
                        System.err.println(errText);
                        scannerInt.nextLine();
                    }
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un valor valido!!");
                    scannerInt.nextLine();
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el estado? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese si el asiento esta activo (s/n): ");
                String sactive = scannerLine.nextLine();
                if (sactive.toLowerCase().contains("s")) {
                    estado = true;
                    break;
                } else {
                    if (sactive.toLowerCase().contains("n")) {
                        break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }

        return new Asiento(id, colectivo, num, estado);
    }
    
    // MÉTODOS DEL RUTAVIAJE
    static public void listRuta() {
        System.out.println("Lista de las rutas:");
        ArrayList<RutaViaje> list = rutaData.getList();
        String formatList = "%-3s %-8s %-8s %-8s %-3s %-3s %-3s %-3s %s%n";
        System.out.printf(formatList, "ID:", "| ORIGEN:", "| DESTINO:", "| FECHA VIAJE:", "| SALIDA:", "| LLEGADA:", "| ID COLECTIVO:", "| PRECIO:", "| ESTADO:");
        for (RutaViaje i : list) {
            System.out.printf(formatList, i.getId_ruta(), "| " + i.getOrigen(), "| " + i.getDestino(), "| " + i.getFecha_viaje(), "| " + i.getHora_salida(), "| " + i.getHora_llegada(), "| " + i.getColectivo().getId_colectivo(), "| " + i.getPrecio(), "| " + i.getEstado());
        }
        System.out.println("");
    }

    static public RutaViaje findRuta() {
        System.out.println("");
        listColectivo();
        RutaViaje find = null;
        while (true) {
            try {
                System.out.print("Ingrese 0 para volver!!\nIngrese la ID de la ruta que desea tomar: ");
                int id = scannerInt.nextInt();
                if (id == 0) {
                    System.out.println("Regresando al menu anterior\n");
                    scannerInt.nextLine();
                    break;
                }
                find = rutaData.getById(id);
                if (find != null) {
                    break;
                } else {
                    System.err.println("ERROR: No se encontro la ruta!!");
                }
            } catch (Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }

    static public RutaViaje createRuta(RutaViaje obj) {
        int id = 0;
        String origen = "";
        String destino = "";
        Vector<Integer> fViaje = new Vector<>(Arrays.asList(1, 1, 1));
        Vector<Integer> hSalida = new Vector<>(Arrays.asList(1, 1, 1));
        Vector<Integer> hLlegada = new Vector<>(Arrays.asList(1, 1, 1));
        Colectivo colectivo = null;
        double precio = 0;
        boolean estado = false;

        if (obj != null) {
            id = obj.getId_ruta();
            origen = obj.getOrigen();
            destino = obj.getDestino();
            fViaje.set(0,obj.getFecha_viaje().getDayOfMonth());
            fViaje.set(1,obj.getFecha_viaje().getMonthValue());
            fViaje.set(2,obj.getFecha_viaje().getYear());
            hSalida.set(0,obj.getHora_salida().getHour());
            hSalida.set(1,obj.getHora_salida().getMinute());
            hSalida.set(2,obj.getHora_salida().getSecond());
            hLlegada.set(0,obj.getHora_llegada().getHour());
            hLlegada.set(1,obj.getHora_llegada().getMinute());
            hLlegada.set(2,obj.getHora_llegada().getSecond());
            colectivo = obj.getColectivo();
            precio = obj.getPrecio();
            estado = obj.getEstado();
        }
        
        if (verifyChange(obj, "Desea modificar el origen? (s/n): ")) {
            System.out.print("Ingrese el origen del viaje: ");
            origen = scannerLine.nextLine();
        }
        
        if (verifyChange(obj, "Desea modificar el destino? (s/n): ")) {
            System.out.print("Ingrese el destino del viaje: ");
            destino = scannerLine.nextLine();
        }
        
        if (verifyChange(obj, "Desea modificar la fecha del viaje? (s/n): ")) {
            System.out.println("Ingrese la fecha del viaje:");
            var d = 1;
            var m = 1;
            var a = 1;
            while (true) {
                try {
                    System.out.print("Ingrese el anio: ");
                    a = scannerInt.nextInt();
                    LocalDate aa = LocalDate.of(a,m,d);
                    fViaje.set(0,a);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un mes válido!!");
                    scannerInt.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ingrese el mes: ");
                    m = scannerInt.nextInt();
                    LocalDate mm = LocalDate.of(a,m,d);
                    fViaje.set(1,m);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un mes válido!!");
                    scannerInt.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ingrese el dia: ");
                    d = scannerInt.nextInt();
                    LocalDate dd = LocalDate.of(a,m,d);
                    fViaje.set(2,d);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un dia valido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(obj, "Desea modificar la hora de salida? (s/n): ")) {
            System.out.println("Ingrese los datos de la hora de salida:");
            var h = 1;
            var m = 1;
            var s = 1;
            while (true) {
                try {
                    System.out.print("Ingrese la hora: ");
                    h = scannerInt.nextInt();
                    LocalTime hh = LocalTime.of(h,m,s);
                    hSalida.set(0,h);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese una hora valida!!");
                    scannerInt.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ingrese los minutos: ");
                    m = scannerInt.nextInt();
                    LocalTime mm = LocalTime.of(h,m,s);
                    hSalida.set(1,m);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un minuto válido!!");
                    scannerInt.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ingrese los segundos: ");
                    s = scannerInt.nextInt();
                    LocalTime ss = LocalTime.of(h,m,s);
                    hSalida.set(2,s);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un segundo válido!!");
                    scannerInt.nextLine();
                }
            }
        }

        if (verifyChange(obj, "Desea modificar la hora de llegada? (s/n): ")) {
            System.out.println("Ingrese los datos de la hora de llegada:");
            var h = 1;
            var m = 1;
            var s = 1;
            while (true) {
                try {
                    System.out.print("Ingrese la hora: ");
                    h = scannerInt.nextInt();
                    LocalTime hh = LocalTime.of(h,m,s);
                    hLlegada.set(0,h);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese una hora valida!!");
                    scannerInt.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ingrese los minutos: ");
                    m = scannerInt.nextInt();
                    LocalTime mm = LocalTime.of(h,m,s);
                    hLlegada.set(1,m);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un minuto válido!!");
                    scannerInt.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Ingrese los segundos: ");
                    s = scannerInt.nextInt();
                    LocalTime ss = LocalTime.of(h,m,s);
                    hLlegada.set(2,s);
                    break;
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un segundo válido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(obj, "Desea modificar el colectivo? (s/n): ")) {
            colectivo = findColectivo();
        }
        
        if (verifyChange(obj, "Desea modificar el precio? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el precio del viaje: ");
                    precio = scannerInt.nextInt();
                    if (precio < 0) {
                        System.err.println("ERROR: Ingrese un precio válido!!");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("ERROR: Ingrese un precio válido!!");
                    scannerInt.nextLine();
                }
            }
        }

        if (verifyChange(obj, "Desea modificar el estado? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese si el asiento esta activo (s/n): ");
                String sactive = scannerLine.nextLine();
                if (sactive.toLowerCase().contains("s")) {
                    estado = true;
                    break;
                } else {
                    if (sactive.toLowerCase().contains("n")) {
                        break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        
        return new RutaViaje(id,origen,destino,LocalDate.of(fViaje.get(0),fViaje.get(1),fViaje.get(2)),LocalTime.of(hSalida.get(0),hSalida.get(1),hSalida.get(2)),LocalTime.of(hLlegada.get(0),hLlegada.get(1),hLlegada.get(2)),colectivo,precio,estado);
    }

    // OTROS MÉTODOS
    static public boolean verifyChange(Object obj, String msg) {
        boolean result = true;
        if (obj != null) {
            while (true) {
                System.out.print(msg);
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {
                    break;
                } else {
                    if (resp.toLowerCase().contains("n")) {
                        result = false;
                        break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        return result;
    }
}
