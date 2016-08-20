package uk.gov.moj.cpp.outcomes.domain.event;

import uk.gov.justice.domain.annotation.Event;
import uk.gov.moj.cpp.outcomes.domain.HearingEventTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;


@Event("outcomes.events.log-hearingevent")
public class HearingEventAdded {
    private UUID id;
    private UUID hearingId;
    private HearingEventTypeEnum eventType;
    private String userId;
    private LocalDateTime dateAndTime;

    public Wrapper getTest() {
        return test;
    }

    public void setTest(Wrapper test) {
        this.test = test;
    }

    private Wrapper test;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public UUID getHearingId() {
        return hearingId;
    }

    public HearingEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(HearingEventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
