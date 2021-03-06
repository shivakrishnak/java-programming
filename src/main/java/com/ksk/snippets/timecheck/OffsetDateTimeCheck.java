package com.ksk.snippets.timecheck;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeCheck {

    public static void main(String[] args) {
        OffsetDateTime order = OffsetDateTime.parse("2020-10-20T19:00Z");
        System.out.println(order  + " | " + order.toEpochSecond());

        OffsetDateTime start = OffsetDateTime.now(ZoneOffset.UTC).withHour(8).withMinute(0).withSecond(0).withNano(0);
        OffsetDateTime end = OffsetDateTime.now().withHour(17).withMinute(0).withSecond(0).withNano(0);

        System.out.println(start  + " | " + end);
        System.out.println(order.isBefore(start));
        System.out.println(order.isAfter(end));
    }
}

