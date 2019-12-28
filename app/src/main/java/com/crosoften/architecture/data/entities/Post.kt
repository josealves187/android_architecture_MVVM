package com.crosoften.architecture.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Classe que fornece um modelo para post
 * @constructor Define todas as propriedades da postagem.
 * @property userId o identificador único do autor do post.
 * @property id o identificador único da postagem.
 * @property title o titulo do post.
 * @property body o conteúdo do post.
 */
@Entity
data class Post(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)