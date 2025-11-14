import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        // clave = cedula
        // valor = cliente/empleado
        Map<String,Cliente> clientes = new HashMap<>();
        Map<String,Empleado> empleados = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        do {
            System.out.println("----Bienvenido al sistema Bancario----");
            System.out.println("1. Ingresar como cliente");
            System.out.println("2. Ingresar como empleado");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Registrar empleado");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");

            try {
                opc = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese un numero valido.");
                continue;
            }

            // =============== MOSTRAR CLIENTE==============
            if (opc == 1) {

                System.out.print("Ingrese su cedula: ");
                String cedula_cliente = scanner.nextLine();

                if (!clientes.containsKey(cedula_cliente)) {
                    System.out.println("Cliente no registrado. Intentelo nuevamente.\n");
                } else {
                    Cliente c = clientes.get(cedula_cliente);
                    System.out.println("Bienvenido " + c.getNombre());
                    System.out.println("Tipo de cuenta: " + c.getTipoCuenta());
                    System.out.println("Ahorros: " + c.getAhorros());
                }
            }

            // ===========MOSTRAR EMPLEADO===========
            else if (opc == 2) {

                System.out.print("Ingrese su cedula: ");
                String cedula_empleado = scanner.nextLine();

                if (!empleados.containsKey(cedula_empleado)) {
                    System.out.println("Empleado no registrado.\n");
                } else {
                    Empleado e = empleados.get(cedula_empleado);
                    System.out.println("Bienvenido " + e.getNombre());
                    e.mostrarRol();     // Se apega a tu diseño original
                }
            }

            // =================REGISTRAR CLIENTE==================
            else if (opc == 3) {

                System.out.println("\n--- Registrar Cliente ---");

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Cedula: ");
                String cedula = scanner.nextLine();

                if (clientes.containsKey(cedula)) {
                    System.out.println("Ya existe un cliente con esta cedula.\n");
                    continue;
                }

                System.out.print("Direccion: ");
                String direccion = scanner.nextLine();

                System.out.print("Telefono: ");
                String telefono = scanner.nextLine();

                System.out.print("Tipo de cuenta: ");
                String tipoCuenta = scanner.nextLine();

                System.out.print("Ahorros iniciales: ");
                double ahorros = 0;

                try {
                    ahorros = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Valor invalido, se guardara 0 en ahorros.");
                }

                int idCliente = clientes.size() + 1;

                Cliente nuevo = new Cliente(nombre, cedula, direccion, telefono,"Cliente", idCliente, tipoCuenta, ahorros);

                clientes.put(cedula, nuevo);
                System.out.println("Cliente registrado exitosamente.\n");
            }

            // ===========REGISTRAR EMPLEADO =================
            else if (opc == 4) {

                System.out.println("\n--- Registrar Empleado ---");

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Cedula: ");
                String cedula = scanner.nextLine();

                if (empleados.containsKey(cedula)) {
                    System.out.println("Ya existe un empleado con esta cedula.\n");
                    continue;
                }

                System.out.print("Direccion: ");
                String direccion = scanner.nextLine();

                System.out.print("Telefono: ");
                String telefono = scanner.nextLine();

                System.out.println("Puesto:");
                System.out.println("1. Cajero");
                System.out.println("2. Balcon de servicio");
                System.out.println("3. Gerente");
                System.out.print("Elija una opción: ");
                int tipo = 0;

                try {
                    tipo = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Opcion invalida.Intentelo nuevamente\n");
                    continue;
                }

                int idEmpleado = empleados.size() + 1;
                Empleado nuevoEmp = null;

                if (tipo == 1) {
                    System.out.print("Cubiculo: ");
                    int cub = Integer.parseInt(scanner.nextLine());
                    nuevoEmp = new Cajero(nombre, cedula, direccion, telefono,"Empleado", idEmpleado, "Cajero", cub);
                } else if (tipo == 2) {
                    System.out.print("Oficina: ");
                    int of = Integer.parseInt(scanner.nextLine());
                    nuevoEmp = new Balcon_Servicio(nombre, cedula, direccion, telefono,"Empleado", idEmpleado, "Balcon", of);
                } else if (tipo == 3) {
                    System.out.print("Sucursal: ");
                    String suc = scanner.nextLine();
                    nuevoEmp = new Gerente(nombre, cedula, direccion, telefono,"Empleado", idEmpleado, "Gerente", suc);
                } else {
                    System.out.println("Puesto inexistente.\n");
                    continue;
                }

                empleados.put(cedula, nuevoEmp);
                System.out.println("Empleado registrado exitosamente.\n");

            }

            else {
                System.out.println("Opcion inexistente.\n");
            }

        } while (opc != 5);

        System.out.println("Gracias por usar el sistema.");
    }
}
