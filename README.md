# ♻️ Ecoverde API

API REST para la gestión de:

- 🗓️ Días de recolección de basura
- 📍 Puntos de recolección
- ♻️ Tips de reciclaje

---

## 🌐 Base URL
http://localhost:8080/api/


---

## 📦 Endpoints disponibles

### 1. 🗓️ Días de Recolección de Basura

**Ruta base:** `/api/garbage-days`

| Método | Ruta       | Descripción                            | Body requerido |
|--------|------------|----------------------------------------|----------------|
| GET    | `/`        | Obtener todos los días de recolección  | No             |
| GET    | `/{id}`    | Obtener un día por ID                  | No             |
| POST   | `/`        | Crear un nuevo día                     | Sí             |
| DELETE | `/{id}`    | Eliminar un día por ID                 | No             |

#### 📥 JSON ejemplo para POST `/api/garbage-days`:

```json
{
  "dayOfWeek": "MONDAY",
  "description": "Recolección general de residuos orgánicos"
}
```
#### 📥 JSON ejemplo para POST `/api/garbage-points`:
```
{
  "name": "Punto Central Plaza",
  "latitude": -17.783327,
  "longitude": -63.182116,
  "description": "Contenedor grande para residuos secos"
}


