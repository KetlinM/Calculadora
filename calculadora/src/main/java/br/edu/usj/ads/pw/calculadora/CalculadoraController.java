package br.edu.usj.ads.pw.calculadora;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class CalculadoraController {
    @GetMapping
    public ModelAndView calculadora() {
        return new ModelAndView("calculadora");
    }

    @PostMapping("/resultado")
    public ModelAndView resultado(
        @RequestParam Double num1,@RequestParam Double num2, @RequestParam String operacao) {
        ModelAndView modelAndView =  new ModelAndView("resultado");
        modelAndView.addObject("resultado", getResultado(num1, num2, operacao));
        return modelAndView;
    }

    private Double getResultado (Double num1, Double num2, String operacao) {
        Double resultado;
        switch (operacao) {
            case "adicao":
                resultado = num1 + num2;
                break;
            case "subtracao":
                resultado = num1 - num2;
                break;
            case "multiplicacao":
                resultado = num1 * num2;
                break;
            case "divisao":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    resultado = 0.0;
                }
                break;
            default:
                resultado = 0.0;
                break;
        }
        return resultado;
    }  
}
