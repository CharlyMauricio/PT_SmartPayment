package com.technical.test.smartpayment.ui.screens.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technical.test.smartpayment.api.repository.tasks.PlanetsTasks
import com.technical.test.smartpayment.api.util.ApiResponseStatus
import com.technical.test.smartpayment.model.PlanetData
import com.technical.test.smartpayment.model.PlanetsList
import com.technical.test.smartpayment.model.UserData
import com.technical.test.smartpayment.room.dto.UserDTOMapper
import com.technical.test.smartpayment.room.entity.UserEntityDB
import com.technical.test.smartpayment.room.repository.UserDBRepository
import com.technical.test.smartpayment.ui.utils.UserStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val planetRepository: PlanetsTasks,
    private val dataBaseRepository: UserDBRepository
) : ViewModel() {

    var status = mutableStateOf<ApiResponseStatus<Any>?>(null)
        private set

    var userStatus = mutableStateOf<UserStatus<Any>?>(null)
        private set

    private var _planetDataList = MutableStateFlow<MutableList<PlanetData>>(mutableListOf())
    val planetDataList: StateFlow<MutableList<PlanetData>>
        get() = _planetDataList


    private var _planetData = MutableStateFlow(
        PlanetData(
            "", "", "", "", "", "", "", "", "", listOf(), listOf(), "", "", "",
        )
    )
    val planetData: StateFlow<PlanetData>
        get() = _planetData

    private var _userDataList = MutableStateFlow<MutableList<UserData>>(mutableListOf())
    val userDataList: StateFlow<MutableList<UserData>>
        get() = _userDataList

    init {
        getUserListDB()
    }

    fun getPlanetList(page: Int) {
        viewModelScope.launch {
            status.value = ApiResponseStatus.Loading()
            handlePlanetList(planetRepository.getPlanetsList(page))
        }
    }

    private fun handlePlanetList(apiResponseStatus: ApiResponseStatus<PlanetsList>) {
        if (apiResponseStatus is ApiResponseStatus.Success) {
            _planetDataList.value = apiResponseStatus.data.resultsPlanets.toMutableList()
        }
        status.value = apiResponseStatus as ApiResponseStatus<Any>
    }


    fun getPlanetData(idPlanet: String) {
        viewModelScope.launch {
            status.value = ApiResponseStatus.Loading()
            handlePlanetData(planetRepository.getPlanetData(idPlanet))
        }
    }

    private fun handlePlanetData(apiResponseStatus: ApiResponseStatus<PlanetData>) {
        if (apiResponseStatus is ApiResponseStatus.Success) {
            _planetData.value = apiResponseStatus.data
        }
        status.value = apiResponseStatus as ApiResponseStatus<Any>
    }

    private fun getUserListDB() {
        viewModelScope.launch {
            dataBaseRepository.getUserListDB()
                .collect { userDB ->
                    if (userDB.isNotEmpty()) {
                        val userData = _userDataList.value.toMutableList()
                        userDB.forEach {
                            val userDTOMapper = UserDTOMapper()
                            userData.add(userDTOMapper.fromUserDTOToUserDomain(it))
                        }
                        _userDataList.value = userData
                        userStatus.value = UserStatus.Exists()
                        getPlanetList(1)
                    } else {
                        userStatus.value = UserStatus.NoExists()
                    }
                }
        }
    }

    fun addUserDB(
        name: String,
        surnamePaternal: String,
        surnameMaternal: String,
        birthdate: String,
        country: String
    ) {
        viewModelScope.launch {
            dataBaseRepository.insertUserDB(
                UserEntityDB(
                    name = name,
                    surnamePaternal = surnamePaternal,
                    surnameMaternal = surnameMaternal,
                    birthdate = birthdate,
                    country = country
                )
            )
        }
    }

}