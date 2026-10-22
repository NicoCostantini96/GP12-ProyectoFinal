package Vista;

import Modelo.Pasajero;
import Persistencia.AsientoData;
import Persistencia.ColectivoData;
import Persistencia.PasajeData;
import Persistencia.PasajeroData;
import Persistencia.RutaViajeData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
                System.out.println("QUE DESEA TESTEAR:\n1 - Pasajero\n2 - Colectivo\n3 - Asiento\n4 - RutaViaje\n5 - Pasaje\n6 - Salir");
                System.out.print("\nIngrese el numero de su opcion: ");
                optionSelected = scannerInt.nextInt();
            }catch(Exception e) {
                scannerInt.nextLine();
                System.err.println("ERROR: Ingrese un valor valido!!\n");
            }
            
            while (optionSelected == 1) {
                listPasajero();

                System.out.println(
                    "OPCIONES:\n" +
                    "1 - Agregar un Pasajero\n" +
                    "2 - Eliminar un Pasajero\n" +
                    "3 - Editar un Pasajero\n" +
                    "4 - Salir"
                );

                finishOptions = false; // Reiniciar antes de entrar al menú

                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();

                        switch (optionResult) {
                            case 1: {
                                Pasajero obj = createPasajero(null);
                                pasajeroData.insert(obj);
                                finishOptions = true;
                                break;
                            }

                            case 2: {
                                Pasajero select = findPasajero();
                                pasajeroData.remove(select.getId_pasajero());
                                finishOptions = true;
                                break;
                            }

                            case 3: {
                                Pasajero select = findPasajero();
                                select = createPasajero(select);
                                pasajeroData.update(select);
                                finishOptions = true;
                                break;
                            }

                            case 4: {
                                finishOptions = true;
                                optionSelected = 0;
                                break;
                            }

                            default:
                                System.err.println(
                                    "ERROR: Ingrese un valor disponible!!"
                                );
                        }
                    } catch (Exception e) {
                        System.err.println("ERROR: Ingrese un valor valido!!");
                        scannerInt.nextLine();
                    }
                }
            }
            
            if (optionSelected==6) {
                break;
            }
            
            if ((optionSelected>6 || optionSelected<1) && !finishOptions) {
                System.err.println("ERROR: Ingrese un valor disponible!!\n");
            }
            
        }
    }
    
    // MÉTODOS DEL PASAJERO
    static public void listPasajero (){
            System.out.println("Lista de Pasajeros:");
            ArrayList<Pasajero> list = pasajeroData.getList();
            String formatList = "%-3s %-11s %-3s %-3s %-3s %-3s %s%n";
            System.out.printf(formatList,"ID:","| DNI:","| NOMBRE:","| APELLIDO:","| CORREO:","| TELEFONO:","| ESTADO:");
            for (Pasajero i: list) {System.out.printf(formatList,i.getId_pasajero(),"| "+i.getDni(),"| "+i.getNombre(),"| "+i.getApellido(),"| "+i.getCorreo(),"| "+i.getTelefono(),"| "+i.getEstado());}
            System.out.println("");
    } 
    
    static public Pasajero findPasajero() {
        System.out.println("");
        listPasajero();
        Pasajero find = null;
        while(true) {
            try {
                System.out.print("Ingrese la ID del pasajero que desea tomar: ");
                int id = scannerInt.nextInt();
                find = pasajeroData.getById(id);
                if (find != null) {
                    break;
                }else{
                    System.err.println("ERROR: No se encontro el pasajero!!");
                }
            }catch(Exception e) {
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
        
        if (verifyChange(obj,"Desea modificar el dni? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el DNI del pasajero: ");
                    dni = scannerInt.nextInt();
                    if (String.valueOf(dni).length() == 8) {
                        break;
                    }else{
                        System.err.println("ERROR: Ingrese exactamente 8 numeros!!");
                        scannerInt.nextLine();
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Ingrese un valor valido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(obj,"Desea modificar el nombre? (s/n): ")) {
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
        
        if (verifyChange(obj,"Desea modificar el apellido? (s/n): ")) {
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
        
        if (verifyChange(obj,"Desea modificar el correo? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el correo del pasajero: ");
                correo = scannerLine.nextLine();
                break;
            }
        }

        if (verifyChange(obj,"Desea modificar el telefono? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el telefono del pasajero: ");
                    telefono = scannerInt.nextInt();
                    break;
                }catch(Exception e) {
                    System.err.println("ERROR: Solo se permiten numeros!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(obj,"Desea modificar el estado? (s/n): ")) {
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
        
        return new Pasajero(id,dni,nombre,apellido,correo,telefono,estado);
    }
    
    // OTROS MÉTODOS
    static public boolean verifyChange(Object obj, String msg) {
        boolean result = true;
        if (obj != null) {
            while (true) {
                System.out.print(msg);
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {result = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        return result;
    }
}
