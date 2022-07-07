package com.study.pokemon.model


import com.google.gson.annotations.SerializedName

class PokemonDetailResponse{
    @SerializedName("abilities")
    var abilities: List<Ability?>? = null
    @SerializedName("base_experience")
    var baseExperience: Int? = null
    @SerializedName("forms")
    var forms: List<Form?>? = null
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice>? = null
    @SerializedName("height")
    var height: Int? = null
    @SerializedName("held_items")
    var heldItems: List<Any?>? = null
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("is_default")
    var isDefault: Boolean? = null
    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String? = null
    @SerializedName("moves")
    var moves: List<Move?>? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("order")
    var order: Int? = null
    @SerializedName("past_types")
    var pastTypes: List<Any?>? = null
    @SerializedName("species")
    var species: Species? = null
    @SerializedName("sprites")
    var sprites: Sprites? = null
    @SerializedName("stats")
    var stats: List<Stat?>? = null
    @SerializedName("types")
    var types: List<Type?>? = null
    @SerializedName("weight")
    var weight: Int? = null

    data class Ability(
        @SerializedName("ability")
        var ability: Ability? = null,
        @SerializedName("is_hidden")
        var isHidden: Boolean? = null,
        @SerializedName("slot")
        var slot: Int? = null
    ) {
        data class Ability(
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("url")
            var url: String? = null
        )
    }

    data class Form(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("url")
        var url: String? = null
    )

    data class GameIndice(
        @SerializedName("game_index")
        var gameIndex: Int? = null,
        @SerializedName("version")
        var version: Version? = null
    ) {
        data class Version(
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("url")
            var url: String? = null
        )
    }

    data class Move(
        @SerializedName("move")
        var move: Move? = null,
        @SerializedName("version_group_details")
        var versionGroupDetails: List<VersionGroupDetail?>? = null
    ) {
        data class Move(
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("url")
            var url: String? = null
        )

        data class VersionGroupDetail(
            @SerializedName("level_learned_at")
            var levelLearnedAt: Int? = null,
            @SerializedName("move_learn_method")
            var moveLearnMethod: MoveLearnMethod? = null,
            @SerializedName("version_group")
            var versionGroup: VersionGroup? = null
        ) {
            data class MoveLearnMethod(
                @SerializedName("name")
                var name: String? = null,
                @SerializedName("url")
                var url: String? = null
            )

            data class VersionGroup(
                @SerializedName("name")
                var name: String? = null,
                @SerializedName("url")
                var url: String? = null
            )
        }
    }

    data class Species(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("url")
        var url: String? = null
    )

    data class Sprites(
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_female")
        var backFemale: Any? = null,
        @SerializedName("back_shiny")
        var backShiny: String? = null,
        @SerializedName("back_shiny_female")
        var backShinyFemale: Any? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_female")
        var frontFemale: Any? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: Any? = null,
        @SerializedName("other")
        var other: Other? = null,
        @SerializedName("versions")
        var versions: Versions? = null
    ) {
        data class Other(
            @SerializedName("dream_world")
            var dreamWorld: DreamWorld? = null,
            @SerializedName("home")
            var home: Home? = null,
            @SerializedName("official-artwork")
            var officialArtwork: OfficialArtwork? = null
        ) {
            data class DreamWorld(
                @SerializedName("front_default")
                var frontDefault: String? = null,
                @SerializedName("front_female")
                var frontFemale: Any? = null
            )

            data class Home(
                @SerializedName("front_default")
                var frontDefault: String? = null,
                @SerializedName("front_female")
                var frontFemale: Any? = null,
                @SerializedName("front_shiny")
                var frontShiny: String? = null,
                @SerializedName("front_shiny_female")
                var frontShinyFemale: Any? = null
            )

            data class OfficialArtwork(
                @SerializedName("front_default")
                var frontDefault: String? = null
            )
        }

        data class Versions(
            @SerializedName("generation-i")
            var generationI: GenerationI? = null,
            @SerializedName("generation-ii")
            var generationIi: GenerationIi? = null,
            @SerializedName("generation-iii")
            var generationIii: GenerationIii? = null,
            @SerializedName("generation-iv")
            var generationIv: GenerationIv? = null,
            @SerializedName("generation-v")
            var generationV: GenerationV? = null,
            @SerializedName("generation-vi")
            var generationVi: GenerationVi? = null,
            @SerializedName("generation-vii")
            var generationVii: GenerationVii? = null,
            @SerializedName("generation-viii")
            var generationViii: GenerationViii? = null
        ) {
            data class GenerationI(
                @SerializedName("red-blue")
                var redBlue: RedBlue? = null,
                @SerializedName("yellow")
                var yellow: Yellow? = null
            ) {
                data class RedBlue(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_gray")
                    var backGray: String? = null,
                    @SerializedName("back_transparent")
                    var backTransparent: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_gray")
                    var frontGray: String? = null,
                    @SerializedName("front_transparent")
                    var frontTransparent: String? = null
                )

                data class Yellow(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_gray")
                    var backGray: String? = null,
                    @SerializedName("back_transparent")
                    var backTransparent: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_gray")
                    var frontGray: String? = null,
                    @SerializedName("front_transparent")
                    var frontTransparent: String? = null
                )
            }

            data class GenerationIi(
                @SerializedName("crystal")
                var crystal: Crystal? = null,
                @SerializedName("gold")
                var gold: Gold? = null,
                @SerializedName("silver")
                var silver: Silver? = null
            ) {
                data class Crystal(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("back_shiny_transparent")
                    var backShinyTransparent: String? = null,
                    @SerializedName("back_transparent")
                    var backTransparent: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_transparent")
                    var frontShinyTransparent: String? = null,
                    @SerializedName("front_transparent")
                    var frontTransparent: String? = null
                )

                data class Gold(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_transparent")
                    var frontTransparent: String? = null
                )

                data class Silver(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_transparent")
                    var frontTransparent: String? = null
                )
            }

            data class GenerationIii(
                @SerializedName("emerald")
                var emerald: Emerald? = null,
                @SerializedName("firered-leafgreen")
                var fireredLeafgreen: FireredLeafgreen? = null,
                @SerializedName("ruby-sapphire")
                var rubySapphire: RubySapphire? = null
            ) {
                data class Emerald(
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null
                )

                data class FireredLeafgreen(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null
                )

                data class RubySapphire(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null
                )
            }

            data class GenerationIv(
                @SerializedName("diamond-pearl")
                var diamondPearl: DiamondPearl? = null,
                @SerializedName("heartgold-soulsilver")
                var heartgoldSoulsilver: HeartgoldSoulsilver? = null,
                @SerializedName("platinum")
                var platinum: Platinum? = null
            ) {
                data class DiamondPearl(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_female")
                    var backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                )

                data class HeartgoldSoulsilver(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_female")
                    var backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                )

                data class Platinum(
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_female")
                    var backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                )
            }

            data class GenerationV(
                @SerializedName("black-white")
                var blackWhite: BlackWhite? = null
            ) {
                data class BlackWhite(
                    @SerializedName("animated")
                    var animated: Animated? = null,
                    @SerializedName("back_default")
                    var backDefault: String? = null,
                    @SerializedName("back_female")
                    var backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    var backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    var backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                ) {
                    data class Animated(
                        @SerializedName("back_default")
                        var backDefault: String? = null,
                        @SerializedName("back_female")
                        var backFemale: Any? = null,
                        @SerializedName("back_shiny")
                        var backShiny: String? = null,
                        @SerializedName("back_shiny_female")
                        var backShinyFemale: Any? = null,
                        @SerializedName("front_default")
                        var frontDefault: String? = null,
                        @SerializedName("front_female")
                        var frontFemale: Any? = null,
                        @SerializedName("front_shiny")
                        var frontShiny: String? = null,
                        @SerializedName("front_shiny_female")
                        var frontShinyFemale: Any? = null
                    )
                }
            }

            data class GenerationVi(
                @SerializedName("omegaruby-alphasapphire")
                var omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,
                @SerializedName("x-y")
                var xY: XY? = null
            ) {
                data class OmegarubyAlphasapphire(
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                )

                data class XY(
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                )
            }

            data class GenerationVii(
                @SerializedName("icons")
                var icons: Icons? = null,
                @SerializedName("ultra-sun-ultra-moon")
                var ultraSunUltraMoon: UltraSunUltraMoon? = null
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null
                )

                data class UltraSunUltraMoon(
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    var frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    var frontShinyFemale: Any? = null
                )
            }

            data class GenerationViii(
                @SerializedName("icons")
                var icons: Icons? = null
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    var frontDefault: String? = null,
                    @SerializedName("front_female")
                    var frontFemale: Any? = null
                )
            }
        }
    }

    data class Stat(
        @SerializedName("base_stat")
        var baseStat: Int? = null,
        @SerializedName("effort")
        var effort: Int? = null,
        @SerializedName("stat")
        var stat: Stat? = null
    ) {
        data class Stat(
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("url")
            var url: String? = null
        )
    }

    data class Type(
        @SerializedName("slot")
        var slot: Int? = null,
        @SerializedName("type")
        var type: Type? = null
    ) {
        data class Type(
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("url")
            var url: String? = null
        )
    }
}