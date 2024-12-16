@deleteAndUpdate
Feature: Eliminar y editar tarea
  Background:
    Given que tenemos la app abierta
    And agregamos una tarea
    And ingresamos titulo de tarea "Tarea 1"
    And ingresamos una descripcion de tarea "Decripcion tarea 1"
    And guardamos la tarea
    And verificamos que la tarea se creo correctamente como "Tarea 1"
    When Ingreso a la tarea "Tarea 1"


    Scenario: Eliminar tarea correctamente
      And doy click en eliminar
      And confirmo la eliminacion
      Then tengo que visualizar el texto "No tasks added"

    Scenario: Editar tarea correctamente
      And limpio la caja de texto del titulo
      And editamos el titulo "Tarea Editada"
      And limpiamos la caja de texto notas
      And editamos la nota a "Nota editada"
      And guardamos la tarea
      Then verificamos que la "Tarea Editada" se haya editado correctamente