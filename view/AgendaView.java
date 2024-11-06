package view;

import controller.AgendaController;
import model.Medico;
import model.Paciente;

import java.util.List;
import java.util.Scanner;

public class AgendaView {
    private AgendaController controller;
    private Scanner scanner;

    public AgendaView(AgendaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar médico");
            System.out.println("2. Agendar consulta");
            System.out.println("3. Listar médicos");
            System.out.println("4. Listar pacientes");
            System.out.println("5. Adicionar paciente");
            System.out.println("6. Cancelar agendamento");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarMedico();
                    break;
                case 2:
                    agendarConsulta();
                    break;
                case 3:
                    listarMedicos();
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
                    adicionarPaciente();
                    break;
                case 6:
                    cancelarAgendamento();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarMedico() {
        System.out.print("Digite o nome do médico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite o CPF do médico: ");
        String cpfMedico = scanner.nextLine();

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = scanner.nextLine();

        System.out.print("Digite o valor da consulta: ");
        double valorConsulta = scanner.nextDouble();
        scanner.nextLine(); // Consome a quebra de linha

        controller.adicionarMedico(nomeMedico, cpfMedico, especialidade, valorConsulta);
        System.out.println("Médico adicionado com sucesso!");
    }

    private void listarMedicos() {
        List<Medico> medicos = controller.listarMedicos();
        for (Medico medico : medicos) {
            System.out.println("Médico: " + medico.getNome() + " | Especialidade: " + medico.getEspecialidade()
                    + " | Valor consulta: " + medico.getValorConsulta());
        }
    }

    private void listarPacientes() {
        List<Paciente> pacientes = controller.listarPacientes();
        for (Paciente paciente : pacientes) {
            System.out.println("Paciente: " + paciente.getNome() + " | CPF: " + paciente.getCpf());
        }
    }

    private void adicionarPaciente() {
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        controller.adicionarPaciente(nomePaciente, cpfPaciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    private void agendarConsulta() {
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        System.out.print("Digite a especialidade desejada: ");
        String especialidade = scanner.nextLine();

        System.out.print("Digite o nome do médico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite o horário desejado (HH:mm): ");
        String horarioEscolhido = scanner.nextLine();

        String resultado = controller.agendarConsulta(nomePaciente, especialidade, horarioEscolhido, nomeMedico);
        System.out.println(resultado);
    }

    private void cancelarAgendamento() {
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        System.out.print("Digite o nome do médico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite o horário do agendamento a ser cancelado (HH:mm): ");
        String horarioEscolhido = scanner.nextLine();

        String resultado = controller.cancelarAgendamento(nomePaciente, nomeMedico, horarioEscolhido);
        System.out.println(resultado);
    }
}
