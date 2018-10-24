# Parcial ARSW API

- Daniela González

## Descripción

Su compañía lo ha seleccionado para construir una aplicación que demuestre una simple arquitectura de Microservicios desplegada en Heroku para uno de los clientes más importantes.
Así, han decidido que usted debe construir una aplicación para consultar el mercado de valores de las acciones negociadas en Bolsa.  La aplicación recibirá el identificador de una acción, por ejemplo “MSFT” para Microsoft  y deberá mostrar el histórico de la valoración intra-día, diaria, semanal o mensual. Para esto utilice el API gratuito de https://www.alphavantage.co/documentation (Puede crear una cuenta para obtener la llave para realizar consultas). Se le pide que su implementación sea eficiente en cuanto a recursos así que debe implementar un Caché que permita evitar hacer consultas repetidas al API externo. Finalmente se le pide que muestre como se puede enlazar con otro proveedor de servicios, en este caso utilice llamados como los siguientes (https://api.iextrading.com/1.0/stock/aapl/chart) y revisé la documentación en https://iextrading.com/developer/docs/#chart.

## Diseño
![](img/Diseño.png)
