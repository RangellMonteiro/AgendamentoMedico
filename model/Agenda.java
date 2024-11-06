package model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<String> horariosDisponiveis;

    public Agenda() {
        this.horariosDisponiveis = new ArrayList<>();
        // Inicializando com alguns horários disponíveis.
        horariosDisponiveis.add("08:00");
        horariosDisponiveis.add("09:00");
        horariosDisponiveis.add("10:00");
        horariosDisponiveis.add("11:00");
        horariosDisponiveis.add("13:00");
        horariosDisponiveis.add("14:00");
        horariosDisponiveis.add("15:00");
        horariosDisponiveis.add("16:00");
    }

    // Método para listar os horários disponíveis
    public void listarHorariosDisponiveis() {
        if (horariosDisponiveis.isEmpty()) {
            System.out.println("Não há horários disponíveis.");
        } else {
            for (String horario : horariosDisponiveis) {
                System.out.println(horario);
            }
        }
    }

    // Método para agendar consulta
    public boolean agendarConsulta(String horario) {
        if (horariosDisponiveis.contains(horario)) {
            horariosDisponiveis.remove(horario);
            return true; // Agendamento realizado com sucesso
        }
        return false; // Horário não disponível
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }
}
