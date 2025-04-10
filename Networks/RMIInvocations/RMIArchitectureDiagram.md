# RMI Architecture Diagram

```mermaid
graph LR
    SM[Server/Main (Server)] -->|Creates Registry| REG[Registry]
    REG -->|Binds| CI[CalculusImpl]
    CI -->|Implements| C[Calculus Interface]
    CM[Client/Main (Client)] -->|Looks Up Service| REG
    CM -->|Invokes calculatePayment()| C
```
