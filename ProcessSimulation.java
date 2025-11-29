public class ProcessSimulation {
    static boolean createVacancyRequest() {
        System.out.println("Руководитель: Заявка на вакансию создана.");
        return true;
    }


    static boolean hrCheckVacancy(boolean request) {
        System.out.println("HR: Заявка проверяется...");
        boolean approved = Math.random() > 0.2; // 80% — одобрено
        if (approved)
            System.out.println("HR: Заявка утверждена.");
        else
            System.out.println("HR: Заявка отклонена. Требуется доработка.");
        return approved;
    }


    static void publishVacancy() {
        System.out.println("Система: Вакансия опубликована.");
    }


    static boolean candidateApply() {
        System.out.println("Кандидат: Отправлена анкета.");
        return true;
    }


    static boolean hrCheckCandidate() {
        boolean ok = Math.random() > 0.3; // 70% — подходит
        if (ok)
            System.out.println("HR: Кандидат приглашён на собеседование.");
        else
            System.out.println("HR: Анкета отклонена.");
        return ok;
    }


    static boolean hrInterview() {
        boolean ok = Math.random() > 0.2;
        System.out.println(ok ? "HR: Первичное интервью успешно." : "HR: Интервью провалено.");
        return ok;
    }

    static boolean techInterview() {
        boolean ok = Math.random() > 0.3;
        System.out.println(ok ? "Техническое интервью успешно." : "Техническое интервью провалено.");
        return ok;
    }

    static boolean offerCandidate(boolean success) {
        if (success) {
            System.out.println("Кандидату отправлен оффер.");
            return true;
        } else {
            System.out.println("Кандидату отправлен отказ.");
            return false;
        }
    }

    static void registerEmployee() {
        System.out.println("Система: Новый сотрудник добавлен в базу данных.");
    }

    static void notifyIT() {
        System.out.println("HR: IT-отдел уведомлён о необходимости подготовки рабочего места.");
    }





    static boolean checkVenueAvailability() {
        boolean available = Math.random() > 0.3;
        System.out.println(available ?
                "Система: Площадка доступна." :
                "Система: Площадка недоступна.");
        return available;
    }

    static boolean processPayment() {
        boolean paid = Math.random() > 0.4;
        System.out.println(paid ?
                "Платёж успешно выполнен." :
                "Ошибка оплаты. Клиенту предложено повторить попытку.");
        return paid;
    }

    static void notifyAdmin() {
        System.out.println("Система: Администратор уведомлён о бронировании.");
    }

    static void sendTasksToContractors() {
        System.out.println("Подрядчики: Задачи получены.");
    }

    static void contractorsFinish() {
        System.out.println("Подрядчики: Все задачи выполнены.");
    }

    static void sendClientReviewRequest() {
        System.out.println("Система: Клиенту отправлено уведомление с просьбой оценить сервис.");
    }

    static void sendManagerReport() {
        System.out.println("Система: Менеджеру отправлен отчёт.");
    }



    
    public static void main(String[] args) {

        System.out.println("=========== ПРОЦЕСС НАЙМА СОТРУДНИКОВ ===========");

        boolean request = createVacancyRequest();
        boolean approved = hrCheckVacancy(request);

        if (!approved) {
            System.out.println("Процесс остановлен: заявка требует доработки.");
            return;
        }

        publishVacancy();
        candidateApply();

        if (!hrCheckCandidate()) {
            System.out.println("Процесс остановлен: кандидат отклонён.");
            return;
        }

        boolean hrOK = hrInterview();
        boolean techOK = techInterview();

        boolean offer = offerCandidate(hrOK && techOK);

        if (!offer) {
            System.out.println("Кандидат отказан. Процесс завершён.");
            return;
        }

        registerEmployee();
        notifyIT();


        System.out.println("\n=========== ПРОЦЕСС БРОНИРОВАНИЯ МЕРОПРИЯТИЯ ===========");

        if (!checkVenueAvailability()) {
            System.out.println("Клиенту предложено выбрать другую дату или площадку.");
            return;
        }

        if (!processPayment()) {
            System.out.println("Платёж не прошёл, бронирование не подтверждено.");
            return;
        }

        notifyAdmin();
        sendTasksToContractors();
        contractorsFinish();

        sendClientReviewRequest();
        sendManagerReport();

        System.out.println("\n===== Оба процесса завершены успешно =====");
    }
}
