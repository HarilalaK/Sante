# API REST - Gestion Médicale

## 🔐 Authentification

| Endpoint               | Méthode | Description                                                                 | Rôle     | Exemple d'utilisation                                                                                     |
|------------------------|---------|-----------------------------------------------------------------------------|----------|--------------------------------------------------------------------------------------------------------|
| `/auth/register`       | POST    | Inscription d'un nouvel utilisateur (public, pas besoin de token).       | Public   | `curl -X POST -H "Content-Type: application/json" -d '{"nom":"Dupont","prenom":"Jean","email":"jean@example.com","motDePasse":"password123","role":"PATIENT"}' http://localhost:8764/auth/register` |
| `/auth/login`          | POST    | Connexion d'un utilisateur (public, retourne un token JWT).             | Public   | `curl -X POST -H "Content-Type: application/json" -d '{"email":"jean@example.com","motDePasse":"password123"}' http://localhost:8764/auth/login` |

---

## 🏥 Patients

| Endpoint                     | Méthode | Description                                                                 | Rôle                     | Exemple d'utilisation                                                                                     |
|------------------------------|---------|-----------------------------------------------------------------------------|--------------------------|--------------------------------------------------------------------------------------------------------|
| `/patients`                  | GET     | Lister tous les patients.                                                 | PATIENT, MEDECIN, ADMIN  | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/patients`                        |
| `/patients/{id}`             | GET     | Récupérer un patient par son ID.                                          | PATIENT, MEDECIN, ADMIN  | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/patients/1`                      |
| `/patients`                  | POST    | Créer un nouveau patient.                                                  | PATIENT, MEDECIN, ADMIN  | `curl -X POST -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"nom":"Dupont","prenom":"Jean"}' http://localhost:8764/patients` |
| `/patients/{id}`             | PUT     | Mettre à jour un patient.                                                  | PATIENT, MEDECIN, ADMIN  | `curl -X PUT -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"nom":"Dupont","prenom":"Jean Updated"}' http://localhost:8764/patients/1` |
| `/patients/{id}`             | DELETE  | Supprimer un patient.                                                      | MEDECIN, ADMIN           | `curl -X DELETE -H "Authorization: Bearer <token>" http://localhost:8764/patients/1`                  |
| `/patients/{id}/historique` | GET     | Récupérer l'historique médical d'un patient (consultations, examens, etc.). | PATIENT, MEDECIN, ADMIN  | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/patients/1/historique`           |
| `/patients/{id}/qr`          | GET     | Générer un QR code pour un patient (peut être utilisé pour l'identification rapide). | PATIENT, MEDECIN, ADMIN  | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/patients/1/qr`                 |

---

## 🩺 Consultations

| Endpoint                          | Méthode | Description                                                                 | Rôle               | Exemple d'utilisation                                                                                     |
|-----------------------------------|---------|-----------------------------------------------------------------------------|--------------------|--------------------------------------------------------------------------------------------------------|
| `/consultations`                  | GET     | Lister toutes les consultations.                                          | MEDECIN, ADMIN     | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/consultations`                  |
| `/consultations/{id}`             | GET     | Récupérer une consultation par son ID.                                    | MEDECIN, ADMIN     | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/consultations/1`               |
| `/consultations`                  | POST    | Créer une nouvelle consultation.                                           | MEDECIN, ADMIN     | `curl -X POST -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"diagnostic":"Grippe"}' http://localhost:8764/consultations` |
| `/consultations/{id}`             | PUT     | Mettre à jour une consultation.                                            | MEDECIN, ADMIN     | `curl -X PUT -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"diagnostic":"Grippe sévère"}' http://localhost:8764/consultations/1` |
| `/consultations/{id}`             | DELETE  | Supprimer une consultation.                                                | MEDECIN, ADMIN     | `curl -X DELETE -H "Authorization: Bearer <token>" http://localhost:8764/consultations/1`          |
| `/consultations/patient/{id}`     | GET     | Récupérer les consultations d'un patient spécifique.                      | PATIENT, MEDECIN, ADMIN | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/consultations/patient/1`      |

---

## 🧪 Examens

| Endpoint                     | Méthode | Description                                                                 | Rôle               | Exemple d'utilisation                                                                                     |
|------------------------------|---------|-----------------------------------------------------------------------------|--------------------|--------------------------------------------------------------------------------------------------------|
| `/examens`                   | GET     | Lister tous les examens.                                                   | MEDECIN, ADMIN     | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/examens`                         |
| `/examens/{id}`              | GET     | Récupérer un examen par son ID.                                            | MEDECIN, ADMIN     | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/examens/1`                      |
| `/examens`                   | POST    | Créer un nouvel examen.                                                    | MEDECIN, ADMIN     | `curl -X POST -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"typeExamen":"Prise de sang"}' http://localhost:8764/examens` |
| `/examens/{id}`              | PUT     | Mettre à jour un examen.                                                    | MEDECIN, ADMIN     | `curl -X PUT -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"typeExamen":"Prise de sang complète"}' http://localhost:8764/examens/1` |
| `/examens/{id}`              | DELETE  | Supprimer un examen.                                                        | MEDECIN, ADMIN     | `curl -X DELETE -H "Authorization: Bearer <token>" http://localhost:8764/examens/1`                     |
| `/examens/patient/{id}`      | GET     | Récupérer les examens d'un patient spécifique.                              | PATIENT, MEDECIN, ADMIN | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/examens/patient/1`               |

---

## 🏨 Centres Médicaux

| Endpoint               | Méthode | Description                                                                 | Rôle     | Exemple d'utilisation                                                                                     |
|------------------------|---------|-----------------------------------------------------------------------------|----------|--------------------------------------------------------------------------------------------------------|
| `/centres`             | GET     | Lister tous les centres médicaux.                                          | ADMIN    | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/centres`                         |
| `/centres/{id}`        | GET     | Récupérer un centre médical par son ID.                                    | ADMIN    | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/centres/1`                      |
| `/centres`             | POST    | Créer un nouveau centre médical.                                           | ADMIN    | `curl -X POST -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"nom":"Hôpital Central"}' http://localhost:8764/centres` |
| `/centres/{id}`        | PUT     | Mettre à jour un centre médical.                                           | ADMIN    | `curl -X PUT -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"nom":"Hôpital Central Mis à Jour"}' http://localhost:8764/centres/1` |
| `/centres/{id}`        | DELETE  | Supprimer un centre médical.                                               | ADMIN    | `curl -X DELETE -H "Authorization: Bearer <token>" http://localhost:8764/centres/1`                  |

---

## 📝 Ordonnances

| Endpoint               | Méthode | Description                                                                 | Rôle               | Exemple d'utilisation                                                                                     |
|------------------------|---------|-----------------------------------------------------------------------------|--------------------|--------------------------------------------------------------------------------------------------------|
| `/ordonnances`         | GET     | Lister toutes les ordonnances.                                             | MEDECIN, ADMIN     | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/ordonnances`                      |
| `/ordonnances/{id}`    | GET     | Récupérer une ordonnance par son ID.                                       | MEDECIN, ADMIN     | `curl -X GET -H "Authorization: Bearer <token>" http://localhost:8764/ordonnances/1`                   |
| `/ordonnances`         | POST    | Créer une nouvelle ordonnance.                                             | MEDECIN, ADMIN     | `curl -X POST -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"medicament":"Paracétamol"}' http://localhost:8764/ordonnances` |
| `/ordonnances/{id}`    | PUT     | Mettre à jour une ordonnance.                                              | MEDECIN, ADMIN     | `curl -X PUT -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"medicament":"Paracétamol 500mg"}' http://localhost:8764/ordonnances/1` |
| `/ordonnances/{id}`    | DELETE  | Supprimer une ordonnance.                                                 | MEDECIN, ADMIN     | `curl -X DELETE -H "Authorization: Bearer <token>" http://localhost:8764/ordonnances/1`               |

---

## 🔒 Rôles et Autorisations

| Rôle       | Description                                                                 |
|------------|-----------------------------------------------------------------------------|
| **PATIENT** | Accès aux endpoints liés à son propre profil et historique médical.     |
| **MEDECIN** | Accès aux endpoints des patients, consultations, examens, et ordonnances. |
| **ADMIN**   | Accès complet à tous les endpoints, y compris la gestion des centres médicaux. |

---

## 🔐 Authentification

Tous les endpoints (sauf `/auth/register` et `/auth/login`) nécessitent un **token JWT** dans le header `Authorization` :
