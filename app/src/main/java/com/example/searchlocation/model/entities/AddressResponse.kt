package com.example.searchlocation.model.entities

import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("items") val items: List<Item>,
    @SerializedName("offset") val offset: Int,
    @SerializedName("nextOffset") val nextOffset: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("queryTerms") val queryTerms: List<QueryTerm>
)

data class Item(
    @SerializedName("title") val title: String,
    @SerializedName("id") val id: String,
    @SerializedName("politicalView") val politicalView: String,
    @SerializedName("ontologyId") val ontologyId: String,
    @SerializedName("resultType") val resultType: String,
    @SerializedName("houseNumberType") val houseNumberType: String,
    @SerializedName("addressBlockType") val addressBlockType: String,
    @SerializedName("localityType") val localityType: String,
    @SerializedName("administrativeAreaType") val administrativeAreaType: String,
    @SerializedName("address") val address: Address,
    @SerializedName("position") val position: Position,
    @SerializedName("access") val access: List<Access>,
    @SerializedName("distance") val distance: Int,
    @SerializedName("excursionDistance") val excursionDistance: Int,
    @SerializedName("mapView") val mapView: MapView,
    @SerializedName("categories") val categories: List<Category>,
    @SerializedName("chains") val chains: List<Chain>,
    @SerializedName("references") val references: List<Reference>,
    @SerializedName("foodTypes") val foodTypes: List<FoodType>,
    @SerializedName("contacts") val contacts: List<Contact>,
    @SerializedName("openingHours") val openingHours: List<OpeningHour>,
    @SerializedName("timeZone") val timeZone: TimeZone,
    @SerializedName("highlights") val highlights: Highlights,
    @SerializedName("phonemes") val phonemes: Phonemes,
    @SerializedName("media") val media: Media,
    @SerializedName("streetInfo") val streetInfo: List<StreetInfo>,
    @SerializedName("accessRestrictions") val accessRestrictions: List<AccessRestriction>
)

data class Address(
    @SerializedName("label") val label: String,
    @SerializedName("countryCode") val countryCode: String,
    @SerializedName("countryName") val countryName: String,
    @SerializedName("stateCode") val stateCode: String,
    @SerializedName("state") val state: String,
    @SerializedName("countyCode") val countyCode: String,
    @SerializedName("county") val county: String,
    @SerializedName("city") val city: String,
    @SerializedName("district") val district: String,
    @SerializedName("subdistrict") val subdistrict: String,
    @SerializedName("street") val street: String,
    @SerializedName("streets") val streets: List<String>,
    @SerializedName("block") val block: String,
    @SerializedName("subblock") val subblock: String,
    @SerializedName("postalCode") val postalCode: String,
    @SerializedName("houseNumber") val houseNumber: String,
    @SerializedName("building") val building: String,
    @SerializedName("unit") val unit: String
)

data class Position(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)

data class Access(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)

data class MapView(
    @SerializedName("west") val west: Double,
    @SerializedName("south") val south: Double,
    @SerializedName("east") val east: Double,
    @SerializedName("north") val north: Double
)

data class Category(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("primary") val primary: Boolean
)

data class Chain(
    @SerializedName("id") val id: String
)

data class Reference(
    @SerializedName("supplier") val supplier: Supplier,
    @SerializedName("id") val id: String
)

data class Supplier(
    @SerializedName("id") val id: String
)

data class FoodType(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("primary") val primary: Boolean
)

data class Contact(
    @SerializedName("phone") val phone: List<Phone>,
    @SerializedName("mobile") val mobile: List<Phone>,
    @SerializedName("tollFree") val tollFree: List<Phone>,
    @SerializedName("fax") val fax: List<Phone>,
    @SerializedName("www") val www: List<Website>,
    @SerializedName("email") val email: List<Email>
)

data class Phone(
    @SerializedName("label") val label: String,
    @SerializedName("value") val value: String,
    @SerializedName("categories") val categories: List<Category>
)

data class Website(
    @SerializedName("label") val label: String,
    @SerializedName("value") val value: String,
    @SerializedName("categories") val categories: List<Category>
)

data class Email(
    @SerializedName("label") val label: String,
    @SerializedName("value") val value: String,
    @SerializedName("categories") val categories: List<Category>
)

data class OpeningHour(
    @SerializedName("categories") val categories: List<Category>,
    @SerializedName("text") val text: List<String>,
    @SerializedName("isOpen") val isOpen: Boolean,
    @SerializedName("structured") val structured: List<Structured>
)

data class Structured(
    @SerializedName("start") val start: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("recurrence") val recurrence: String
)

data class TimeZone(
    @SerializedName("name") val name: String,
    @SerializedName("utcOffset") val utcOffset: String
)

data class Highlights(
    @SerializedName("title") val title: List<HighlightRange>,
    @SerializedName("address") val address: HighlightAddress
)

data class HighlightRange(
    @SerializedName("start") val start: Int,
    @SerializedName("end") val end: Int
)

data class HighlightAddress(
    @SerializedName("label") val label: List<HighlightRange>,
    @SerializedName("country") val country: List<HighlightRange>,
    @SerializedName("countryCode") val countryCode: List<HighlightRange>,
    @SerializedName("state") val state: List<HighlightRange>,
    @SerializedName("stateCode") val stateCode: List<HighlightRange>,
    @SerializedName("county") val county: List<HighlightRange>,
    @SerializedName("countyCode") val countyCode: List<HighlightRange>,
    @SerializedName("city") val city: List<HighlightRange>,
    @SerializedName("district") val district: List<HighlightRange>,
    @SerializedName("subdistrict") val subdistrict: List<HighlightRange>,
    @SerializedName("block") val block: List<HighlightRange>,
    @SerializedName("subblock") val subblock: List<HighlightRange>,
    @SerializedName("street") val street: List<HighlightRange>,
    @SerializedName("streets") val streets: List<List<HighlightRange>>,
    @SerializedName("postalCode") val postalCode: List<HighlightRange>,
    @SerializedName("houseNumber") val houseNumber: List<HighlightRange>,
    @SerializedName("building") val building: List<HighlightRange>
)

data class Phonemes(
    @SerializedName("placeName") val placeName: List<Phoneme>,
    @SerializedName("countryName") val countryName: List<Phoneme>,
    @SerializedName("state") val state: List<Phoneme>,
    @SerializedName("county") val county: List<Phoneme>,
    @SerializedName("city") val city: List<Phoneme>,
    @SerializedName("district") val district: List<Phoneme>,
    @SerializedName("subdistrict") val subdistrict: List<Phoneme>,
    @SerializedName("street") val street: List<Phoneme>,
    @SerializedName("block") val block: List<Phoneme>,
    @SerializedName("subblock") val subblock: List<Phoneme>
)

data class Phoneme(
    @SerializedName("value") val value: String,
    @SerializedName("language") val language: String,
    @SerializedName("preferred") val preferred: Boolean
)

data class Media(
    @SerializedName("images") val images: MediaItems,
    @SerializedName("editorials") val editorials: MediaItems,
    @SerializedName("ratings") val ratings: MediaItems
)

data class MediaItems(
    @SerializedName("items") val items: List<MediaItem>
)

data class MediaItem(
    @SerializedName("href") val href: String,
    @SerializedName("date") val date: String,
    @SerializedName("supplier") val supplier: Supplier,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("count") val count: Int?,
    @SerializedName("average") val average: Double?
)

data class StreetInfo(
    @SerializedName("baseName") val baseName: String,
    @SerializedName("streetType") val streetType: String,
    @SerializedName("streetTypePrecedes") val streetTypePrecedes: Boolean,
    @SerializedName("streetTypeAttached") val streetTypeAttached: Boolean,
    @SerializedName("prefix") val prefix: String,
    @SerializedName("suffix") val suffix: String,
    @SerializedName("direction") val direction: String,
    @SerializedName("language") val language: String
)

data class AccessRestriction(
    @SerializedName("categories") val categories: List<Category>,
    @SerializedName("restricted") val restricted: Boolean
)

data class QueryTerm(
    @SerializedName("term") val term: String,
    @SerializedName("replaces") val replaces: String,
    @SerializedName("start") val start: Int,
    @SerializedName("end") val end: Int
)
