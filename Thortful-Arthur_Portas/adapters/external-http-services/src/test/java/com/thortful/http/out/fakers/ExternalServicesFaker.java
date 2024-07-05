package com.thortful.http.out.fakers;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ExternalServicesFaker extends Faker {

    private final Faker faker = new Faker();

  /*  public NodeRequestFilter.Builder nodeRequestFilter() {

        return NodeRequestFilter.builder()
                .orderNumber(harryPotter().spell())
                .paymentMethodSid(sid())
                .paymentMethodName(finance().creditCard())
                .street(address().streetAddress())
                .city(address().city())
                .region(address().state())
                .network(country().countryCode2())
                .requirements(Collections.emptySet())
                .capabilities(Collections.emptySet())
                .businessClientCode(letterify("????-") + country().countryCode2());
    }

    public SkyPrimeNodeResponse skyPrimeNodeResponse() {

        return new SkyPrimeNodeResponse(sid(), company().name());
    }

    public UUID sid() {

        return UUID.randomUUID();
    }

    public TrackingNumberResponse.Builder trackingNumberResponse() {

        return TrackingNumberResponse.builder()
                .orderNumber(lorem().characters(10))
                .externalBusinessClientId(lorem().characters(10))
                .tracking(TrackingNumberResponse.Tracking.builder()
                                  .number(lorem().characters(5))
                                  .parcelNumber(lorem().characters(3))
                                  .member(lorem().characters(10))
                                  .lastMileHub(lorem().characters(15))
                                  .label(lorem().characters(5))
                                  .build());
    }

    public RingStatementsResponse.Builder ringStatementsResponse() {

        return RingStatementsResponse.builder()
                .results(Collections.singletonList(
                        RingStatementsResponse.Result.builder()
                                .id(number().randomNumber())
                                .code(lorem().characters(5))
                                .type(RingStatementType.PAYOUT)
                                .status(RingStatementStatus.OPEN)
                                .targetShop(
                                        new RingStatementsResponse.TargetShop(
                                                new RingStatementsResponse.Currency(currency().code())))
                                .amount(bigDecimal())
                                .opensAtLocalTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                                .closesAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                                .build()));
    }

    public RingStatementsResponse.Builder ringStatementsResponseWithNullStatus() {

        return RingStatementsResponse.builder()
                .results(Collections.singletonList(
                        RingStatementsResponse.Result.builder()
                                .id(number().randomNumber())
                                .code(lorem().characters(5))
                                .type(RingStatementType.PAYOUT)
                                .status(null)
                                .targetShop(
                                        new RingStatementsResponse.TargetShop(
                                                new RingStatementsResponse.Currency(currency().code())))
                                .amount(bigDecimal())
                                .opensAtLocalTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                                .closesAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                                .build()));
    }

    public RingTransactionsResponse.Builder ringTransactionsResponse() {

        return RingTransactionsResponse.builder()
                .results(Collections.singletonList(
                        RingTransactionsResponse.Result.builder()
                                .number(lorem().characters(10))
                                .amount(bigDecimal())
                                .shop(new RingTransactionsResponse.Shop(new RingTransactionsResponse.Currency(currency().code())))
                                .statementPayout(new RingTransactionsResponse.StatementPayout(lorem().characters(5)))
                                .statementInvoice(new RingTransactionsResponse.StatementInvoice(lorem().characters(5)))
                                .trackingNumber(lorem().characters())
                                .transactionType(lorem().characters())
                                .createdAtLocalTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                                .notes(lorem().characters())
                                .build()));
    }

    public RingTransactionsResponse.Builder ringTransactionsResponseWithNullStatementPayout() {

        return RingTransactionsResponse.builder()
                .results(Collections.singletonList(
                        RingTransactionsResponse.Result.builder()
                                .number(lorem().characters(10))
                                .amount(bigDecimal())
                                .shop(new RingTransactionsResponse.Shop(new RingTransactionsResponse.Currency(currency().code())))
                                .statementPayout(null)
                                .statementInvoice(new RingTransactionsResponse.StatementInvoice(lorem().characters(5)))
                                .build()));
    }

    public RingTransactionsResponse.Builder ringTransactionsResponseWithNullStatementInvoice() {

        return RingTransactionsResponse.builder()
                .results(Collections.singletonList(
                        RingTransactionsResponse.Result.builder()
                                .number(lorem().characters(10))
                                .amount(bigDecimal())
                                .shop(new RingTransactionsResponse.Shop(new RingTransactionsResponse.Currency(currency().code())))
                                .statementPayout(new RingTransactionsResponse.StatementPayout(lorem().characters(5)))
                                .statementInvoice(null)
                                .build()));
    }

    public RingStatementDetailsResponse.Builder ringStatementDetailsResponse() {

        return RingStatementDetailsResponse.builder()
                .id(9876)
                .code("code")
                .type(RingStatementType.PAYOUT)
                .status(RingStatementStatus.OPEN)
                .targetShop(
                        new RingStatementDetailsResponse.TargetShop(
                                new RingStatementDetailsResponse.TargetShop.Currency("DZD")))
                .openingBalance(BigDecimal.TEN)
                .closingBalance(BigDecimal.ONE)
                .opensAtLocalTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .closesAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public RingStatementDetailsResponse.Builder ringStatementDetailsResponseWithNullStatus() {

        return RingStatementDetailsResponse.builder()
                .id(9876)
                .code("code")
                .type(RingStatementType.PAYOUT)
                .status(null)
                .targetShop(
                        new RingStatementDetailsResponse.TargetShop(
                                new RingStatementDetailsResponse.TargetShop.Currency(currency().code())))
                .openingBalance(bigDecimal())
                .closingBalance(bigDecimal())
                .opensAtLocalTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .closesAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public RingStatementTransactionsResponse.Builder ringStatementTransactionsResponse() {

        return RingStatementTransactionsResponse.builder()
                .amount(BigDecimal.TEN)
                .currency(new RingStatementTransactionsResponse.Currency("DZD"))
                .transactionType(
                        new RingStatementTransactionsResponse.TransactionType("transaction"));
    }

    public RingStatementExportResponse.Builder ringStatementExportResponse() {

        return RingStatementExportResponse.builder()
                .id(number().randomNumber())
                .status("Executing")
                .createdAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public RingExportResponse.Builder ringExportResponse() {

        return RingExportResponse.builder()
                .id(number().randomNumber())
                .status("Completed")
                .fileUrl(internet().url())
                .createdAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public ReasonResponse.Builder reasonResponse() {

        return ReasonResponse.builder()
                .id(number().randomNumber())
                .name(name().name());
    }

    public PackageResponse.Builder packageResponse(Package pkg) {

        return PackageResponse.builder()
                .sid(pkg.getSid())
                .trackingNumber(pkg.getTrackingNumber());
    }

    public UserResponse.Builder userResponse() {

        return UserResponse.builder()
                .sid(sid())
                .name(name().firstName())
                .username(internet().emailAddress())
                .status(AclUserStatus.ACTIVE)
                .userType(AclUserType.MACHINE);
    }

    private BigDecimal bigDecimal() {

        return BigDecimal.valueOf(number().randomDouble(2, 0, Integer.MAX_VALUE));
    }

    public HmtDepotContentLinkResponse.Builder hmtDepotContentLinkResponse() {

        return HmtDepotContentLinkResponse.builder()
                .url(lorem().characters(10, 20))
                .type("ID_CARD_IMAGE");
    }

    public BusinessClientApiCreationResponse.BusinessClientApiCreationResponseBuilder businessClientApiCreationResponse() {

        return BusinessClientApiCreationResponse.builder()
                .code(regexify("^[a-z]{2}-[0-9]{5}$"))
                .entityName(company().name())
                .displayName(funnyName().name())
                .finance(financeDetails().build())
                .network(Network.builder().code(country().countryCode2()).build())
                .sid(sid());
    }

    private BusinessClientApiCreationResponse.FinanceDetails.FinanceDetailsBuilder financeDetails() {

        return BusinessClientApiCreationResponse.FinanceDetails.builder()
                .postpaid(bool().bool());
    }

    public BusinessClientApiDocumentUploadResponse.BusinessClientApiDocumentUploadResponseBuilder businessClientApiDocumentUploadResponse() {

        return BusinessClientApiDocumentUploadResponse.builder()
                .fileName(lorem().word())
                .sid(sid());
    }

    public AclUserApplicationResponse aclUserApplicationResponse() {

        return new AclUserApplicationResponse(new AclUserApplicationResponse.UserApplicationResponse(new Random().nextLong(),
                                                                                                     company().name(),
                                                                                                     company().name()));
    }*/
}
